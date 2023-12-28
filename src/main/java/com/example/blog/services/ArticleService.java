package com.example.blog.services;

import com.example.blog.dtos.user.article.ArticleDto;
import com.example.blog.dtos.user.article.ArticleResponseDto;
import com.example.blog.models.decuments.Article;
import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.User;
import com.example.blog.repositories.ArticleRepository;
import com.example.blog.repositories.CommentRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.interfaces.ArticleInt;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService implements ArticleInt {
  private final ModelMapper modelMapper;
  private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;



    public ArticleService(ModelMapper modelMapper, ArticleRepository articleRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }
    @Override
    @Transactional
    public ArticleResponseDto add(ArticleDto articleDto) {
        try {
            Article article = modelMapper.map(articleDto, Article.class);
            article.setPostingTime(LocalDateTime.now());
            Article savedArticle = articleRepository.save(article);
            User user = userRepository.findById(articleDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("No user found with ID: " + articleDto.getUserId()));

            // Associer l'utilisateur à l'article
            article.setUser(user);
            return modelMapper.map(savedArticle, ArticleResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save article: " + e.getMessage());
        }
    }


    @Override
    @Transactional
    public List<ArticleResponseDto> getAll(Pageable pageable) {
        try {
            Page<Article> articlePage = articleRepository.findAll(pageable);
            List<Article> articles = articlePage.getContent();
            List<ArticleResponseDto> responseDtoList = new ArrayList<>();
            for (Article article : articles) {
                LocalDateTime postingTime = article.getPostingTime();
                if (postingTime != null) {
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    Duration duration = Duration.between(postingTime, currentDateTime);

                    String timeDifference;
                    if (duration.toHours() >= 2) {
                        timeDifference = duration.toHours() + " hours ago";
                    } else if (duration.toHours() >= 1) {
                        timeDifference = "1 hour ago";
                    } else if (duration.toMinutes() >= 2) {
                        timeDifference = duration.toMinutes() + " minutes ago";
                    } else if (duration.toMinutes() >= 1) {
                        timeDifference = "1 minute ago";
                    } else {
                        timeDifference = "just now";
                    }

                    // Charger les références
                    article.setUser(loadUserReference(article.getUser()));
                    article.setComments(loadCommentReferences(article.getComments()));

                    ArticleResponseDto responseDto = modelMapper.map(article, ArticleResponseDto.class);
                    responseDto.setPostingTimeFormatted(timeDifference);
                    responseDtoList.add(responseDto);
                }
            }

            return responseDtoList;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve articles: " + e.getMessage(), e);
        }
    }

    private User loadUserReference(User user) {
        if (user != null) {
            return userRepository.findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("No user found with ID: " + user.getId()));
        }
        return null;
    }

    private List<Comment> loadCommentReferences(List<Comment> comments) {
        if (comments != null) {
            return comments.stream()
                    .map(comment -> commentRepository.findById(comment.getId())
                            .orElseThrow(() -> new RuntimeException("No comment found with ID: " + comment.getId())))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    @Transactional
    public List<ArticleResponseDto> searchArticles(String search) {
        List<Article> articles;
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        if (search != null) {
            articles = articleRepository.findByTagsContainingOrTextContainingOrTitleContaining(search, search, search);
            for (Article article : articles) {
                ArticleResponseDto articleResponseDto = modelMapper.map(article, ArticleResponseDto.class);
                articleResponseDtos.add(articleResponseDto);
            }
        }

        return articleResponseDtos;
    }

}

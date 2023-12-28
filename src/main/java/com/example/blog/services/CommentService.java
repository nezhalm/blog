package com.example.blog.services;
import com.example.blog.dtos.user.comment.CommentDto;
import com.example.blog.dtos.user.comment.CommentResponseDto;
import com.example.blog.models.decuments.Article;
import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.User;
import com.example.blog.repositories.ArticleRepository;
import com.example.blog.repositories.CommentRepository;
import com.example.blog.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, ModelMapper modelMapper, UserRepository userRepository, CommentRepository commentRepository1) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository1;
    }

    public CommentResponseDto save(CommentDto commentDto) {
        Comment comment = new Comment();

        // Mappage explicite des propriétés
        comment.setUser(userRepository.findById(commentDto.getUserId()).get());
        comment.setArticle(articleRepository.findById(commentDto.getArticleId()).get());
        // Assurez-vous de mapper d'autres propriétés si nécessaire

        // Récupérer l'article à partir de son ID
        Article article = articleRepository.findById(comment.getArticle().getId())
                .orElseThrow(() -> new RuntimeException("No article found with ID: " + comment.getArticle().getId()));

        // Récupérer l'utilisateur à partir de son ID
        User user = userRepository.findById(comment.getUser().getId())
                .orElseThrow(() -> new RuntimeException("No user found with ID: " + comment.getUser().getId()));

        // Setters manuels pour éviter l'ambiguïté
        comment.setArticle(article);
        comment.setUser(user);
        comment.setText(commentDto.getText());


        // Enregistrez le commentaire dans la base de données
        Comment savedComment = commentRepository.save(comment);

        // Ajoutez le commentaire à la liste des commentaires de l'article
          article.getComments().add(savedComment);


        // Enregistrez les modifications de l'article dans la base de données
        Article savedArticle = articleRepository.save(article);

        // Mapper le commentaire en CommentResponseDto et retournez-le
        return modelMapper.map(savedComment, CommentResponseDto.class);
    }



}

package com.example.blog.services.interfaces;

import com.example.blog.dtos.user.UserDto;
import com.example.blog.dtos.user.UserResponseDto;
import com.example.blog.dtos.user.article.ArticleDto;
import com.example.blog.dtos.user.article.ArticleResponseDto;
import com.example.blog.models.decuments.Article;
import org.springframework.data.annotation.Id;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ArticleInt  {
    ArticleResponseDto add(ArticleDto Element) ;
    List<ArticleResponseDto> getAll(Pageable pageable);
    List<ArticleResponseDto> searchArticles(String search);



}

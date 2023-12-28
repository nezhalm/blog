package com.example.blog.dtos.user.comment;
import com.example.blog.dtos.user.UserDto;
import com.example.blog.dtos.user.article.ArticleDto;
import lombok.Data;
@Data
public class CommentResponseDto {
    private String text;
    private ArticleDto article;
    private UserDto user;

}

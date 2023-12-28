package com.example.blog.dtos.user;

import com.example.blog.models.decuments.Article;
import com.example.blog.models.decuments.ArticleReact;
import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.CommentReact;
import lombok.Data;

import java.util.List;
@Data
public class UserResponseDto {
    private String userName;
    private String password;
    private String email;
    private List<Article> articles;
    private List<Comment> comments;
    private List<ArticleReact> articleReacts;
    private List<CommentReact> commentReacts;
}

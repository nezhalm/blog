package com.example.blog.dtos.user.comment;
import lombok.Data;

@Data
public class CommentDto {
    private String text;
    private String articleId;
    private String userId;
}

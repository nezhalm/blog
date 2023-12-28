package com.example.blog.dtos.user.article;
import com.example.blog.dtos.user.comment.CommentResponseDto;
import com.example.blog.models.decuments.ArticleReact;
import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.Media;
import com.example.blog.models.decuments.User;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleResponseDto {
    private String id;
    private String title;
    private String text;
    private String[] tags;
    private User user;
    private String PostingTimeFormatted;
    private List<ArticleReact> articleReacts;
    private List<CommentResponseDto> comments;
    private List<Media> medias;
}

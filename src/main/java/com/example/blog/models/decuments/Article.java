package com.example.blog.models.decuments;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "articles")
public class Article {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime publishTime;
    private String[] Tags;
    private User publisher;
    private List<Comment> comments;
    private List<ArticleReact> reactions;
    private List<Media> media;
}

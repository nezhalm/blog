package com.example.blog.models.decuments;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

@Document(collection = "articles")
public class Article {
    @Id
    private String id;
    private String title;
    private String text;
    private LocalDateTime postingTime;
    private String[] tags;
    @DBRef
    private User user;
    @DBRef
    private List<Comment> comments ;
    @DBRef
    private List<ArticleReact> articleReacts;
    @DBRef
    private List<Media> media;

    public Article() {
        this.comments = new ArrayList<>();
    }
}

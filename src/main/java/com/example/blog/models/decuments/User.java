package com.example.blog.models.decuments;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
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
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    @CreatedDate
    private LocalDate joinDate;
    private List<Article> posts;
    private List<Comment> comments;
    private List<ArticleReact> articleReacts;
    private List<CommentReact> commentReacts;
}


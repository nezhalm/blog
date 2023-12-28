package com.example.blog.models.decuments;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String text;
    @CreatedDate
    private LocalDateTime postingTime;
    @DBRef // Utilisez DBRef pour référencer d'autres documents MongoDB
    private Article article;
    @DBRef
    private User user;
    private List<CommentReact> commentReacts;
}

package com.example.blog.models.decuments;
import java.time.LocalDateTime;
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

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String content;
    @CreatedDate
    private LocalDateTime publishTime;
//    private Article post;
//    private User publisher;
//    private List<CommentReact> reactions;
}

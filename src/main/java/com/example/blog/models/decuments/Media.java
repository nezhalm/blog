package com.example.blog.models.decuments;
import com.example.blog.MediaType;
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

@Document(collection = "media")
public class Media {
    @Id
    private String id;
    private String url;
    private MediaType type;

    private Article article;
}

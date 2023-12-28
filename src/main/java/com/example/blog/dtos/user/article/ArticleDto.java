package com.example.blog.dtos.user.article;
import com.example.blog.MediaType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
    public class ArticleDto {
        private String id;
        private String title;
        private String text;
      //  @JsonSerialize(using = CostumDateTime.class)
        private LocalDateTime postingTime;
        private String[] tags;
        private MediaType media;
        private String userId;

    }


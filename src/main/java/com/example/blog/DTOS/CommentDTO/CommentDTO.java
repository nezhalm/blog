package com.example.blog.DTOS.CommentDTO;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class CommentDTO {
    @Id
    private String id;
    private String content;
    @CreatedDate
    private LocalDateTime publishTime;
}

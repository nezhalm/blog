package com.example.blog.models.decuments;

import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.React;
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

@Document(collection = "comments_reacts")
public final class CommentReact extends React {

    private Comment comment;
}

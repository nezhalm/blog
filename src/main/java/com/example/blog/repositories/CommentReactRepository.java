package com.example.blog.repositories;

import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.CommentReact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentReactRepository extends MongoRepository<CommentReact, String> {
}

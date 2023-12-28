package com.example.blog.repositories;

import com.example.blog.models.decuments.ArticleReact;
import com.example.blog.models.decuments.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleReactRepository extends MongoRepository<ArticleReact, String> {
}

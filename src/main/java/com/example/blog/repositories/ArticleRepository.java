package com.example.blog.repositories;

import com.example.blog.models.decuments.Article;
import com.example.blog.models.decuments.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}

package com.example.blog.repositories;

import com.example.blog.models.decuments.Article;
import com.example.blog.models.decuments.ArticleReact;
import com.example.blog.models.decuments.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleReactRepository extends MongoRepository<ArticleReact, String> {

}

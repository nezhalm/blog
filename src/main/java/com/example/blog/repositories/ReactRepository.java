package com.example.blog.repositories;

import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.React;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReactRepository extends MongoRepository<React, String> {
}

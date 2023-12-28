package com.example.blog.repositories;

import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.Media;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<Media, String> {
}

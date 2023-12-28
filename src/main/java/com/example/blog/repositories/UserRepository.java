package com.example.blog.repositories;

import com.example.blog.models.decuments.Comment;
import com.example.blog.models.decuments.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);

}

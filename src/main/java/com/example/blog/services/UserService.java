package com.example.blog.services;
import com.example.blog.models.decuments.User;
import com.example.blog.services.implementations.UserImp;
import org.springframework.data.annotation.Id;

public class UserService implements UserImp {
    @Override
    public User add(User Element) {
        return null;
    }

    @Override
    public User update(Id id, User elementBody) {
        return null;
    }

    @Override
    public User findById(Id id) {
        return null;
    }

    @Override
    public User delete(Id id) {
        return null;
    }
}

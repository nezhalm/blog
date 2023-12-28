package com.example.blog.services.interfaces;
import com.example.blog.dtos.user.UserDto;
import com.example.blog.dtos.user.UserResponseDto;
import com.example.blog.models.decuments.User;
import org.springframework.data.annotation.Id;
public interface UserInt  {
     UserResponseDto add(UserDto Element) ;
     UserResponseDto auth(UserDto Element);

}

package com.example.blog.services;
import com.example.blog.dtos.user.UserDto;
import com.example.blog.dtos.user.UserResponseDto;
import com.example.blog.models.decuments.User;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.interfaces.UserInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInt {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto add(UserDto Element) {
        User user = modelMapper.map(Element, User.class);
        return modelMapper.map(userRepository.save(user), UserResponseDto.class);
    }

    @Override
    public UserResponseDto auth(UserDto userDto) {
        User existingUser = userRepository.findByUserName(userDto.getUserName());
        if (existingUser != null && existingUser.getPassword().equals(userDto.getPassword())) {
            return modelMapper.map(userDto, UserResponseDto.class);
        } else {
            return null;
        }
    }

}
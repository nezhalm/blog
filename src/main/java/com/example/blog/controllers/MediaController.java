package com.example.blog.controllers;
import com.example.blog.dtos.user.comment.CommentDto;
import com.example.blog.dtos.user.comment.CommentResponseDto;
import com.example.blog.services.CommentService;
import com.example.blog.services.MediaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }


}

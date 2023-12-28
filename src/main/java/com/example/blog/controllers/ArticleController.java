package com.example.blog.controllers;

import com.example.blog.dtos.user.article.ArticleDto;
import com.example.blog.dtos.user.article.ArticleResponseDto;
import com.example.blog.services.ArticleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {
    private final ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PostMapping
    public ResponseEntity<ArticleResponseDto> add(@RequestBody ArticleDto articleDto) {
        ArticleResponseDto savedArticle = articleService.add(articleDto);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ArticleResponseDto> getArticles(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return articleService.getAll(pageable);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleResponseDto>> searchArticles(@RequestParam String search) {
        List<ArticleResponseDto> articleResponseDtos = articleService.searchArticles(search);
        return ResponseEntity.ok(articleResponseDtos);
    }
}

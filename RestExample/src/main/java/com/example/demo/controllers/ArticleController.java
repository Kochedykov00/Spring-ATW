package com.example.demo.controllers;


import com.example.demo.dto.ArticleDto;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{article-id}")
    public ResponseEntity<ArticleDto>getArticle(@PathVariable("article-id") Long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{article-id}")
    public ResponseEntity<?>deleteArticle(@PathVariable("article-id") Long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.accepted().build();
    }

}

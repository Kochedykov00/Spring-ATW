package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Comment;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.ArticleServiceImpl;
import com.example.myfirstspringproject.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/articles")

public class ArticleController {


    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    CommentServiceImpl commentService;


    @PreAuthorize("permitAll()")
    @GetMapping
    public String getArticles (Model model) {
      List<Article> articlesByDate = articleService.getTop5ArticlesByDate();
      List<Article> articlesByRating = articleService.getTop5ArticlesByRating();
        model.addAttribute("articlesByDate", articlesByDate);
        model.addAttribute("articlesByRating", articlesByRating);
        return "articles";
    }

    @GetMapping("/{article-id}")
    public String getConcreteFilm(@PathVariable("article-id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
     //   List <Comment> comments = commentService.getComments(id);
       // model.addAttribute("commnets", comments);
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/createArticle")
    @PreAuthorize("isAuthenticated()")
    public String getCreateArticlePage() {
        return "creating_article";
    }

    @PostMapping("/createArticle")
    @PreAuthorize("isAuthenticated()")
    public String createArticle(Authentication authentication, ArticleDto articleDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        articleService.createArticle(articleDto,userDetails.getUser());
        return "redirect:/";
    }



}

package com.example.articleservice.controllers;


import com.example.articleservice.models.Article;
import com.example.articleservice.services.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@Slf4j
@RequestMapping("/articles")

public class ArticleController {


    @Autowired
    DemoServiceImpl demoService;


    @GetMapping
    public String getArticles (Model model) {
        List<Article> articlesByDate = demoService.getTop5ArticlesByDate();
        List<Article> articlesByRating = demoService.getTop5ArticlesByRating();
        model.addAttribute("articlesByDate", articlesByDate);
        model.addAttribute("articlesByRating", articlesByRating);
        return "articles";
    }

}


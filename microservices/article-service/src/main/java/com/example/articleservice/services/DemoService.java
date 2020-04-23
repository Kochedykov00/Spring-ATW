package com.example.articleservice.services;

import com.example.articleservice.dto.ArticleDto;
import com.example.articleservice.models.Article;
import com.example.articleservice.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DemoService {

    public List<Article> getArticles ();
    public Article getArticleById (long id);
    public void createArticle(ArticleDto articleDto, User user);

}

package com.example.articleservice.services;


import com.example.articleservice.dto.ArticleDto;
import com.example.articleservice.models.Article;
import com.example.articleservice.models.User;
import com.example.articleservice.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Component
public class DemoServiceImpl implements DemoService {


    @Autowired
    ArticleRepository articleRepository;



    public List<Article> getArticles () {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public Article getArticleById (long id) {
        Article article = articleRepository.findArticleById(id);
        return article;
    }

    public List<Article> getTop5ArticlesByDate() {
        List<Article> articles = articleRepository.findTop5ArticlesByDate();
        return articles;
    }

    public List<Article> getTop5ArticlesByRating() {
        List<Article> articles = articleRepository.findTop5ArticlesByRating();
        return articles;
    }

    public void createArticle(ArticleDto articleDto, User user) {
        Date date = new Date();
        Article article = Article.builder()
                .date(date)
                .rating(0)
                .text(articleDto.getText())
                .title(articleDto.getTitle())
                .user(user)
                .photo(articleDto.getPhoto())
                .build();
        articleRepository.save(article);
    }

}

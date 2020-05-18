package com.example.demo.services;

import com.example.demo.dto.ArticleDto;
import com.example.demo.models.Article;
import com.example.demo.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticlesRepository articlesRepository;


    public List<ArticleDto> getArticlesByIdUser(long id) {
        List<Article> articles = articlesRepository.findArticlesByUserId(id);
        return ArticleDto.from(articles);
    }

    public ArticleDto getArticleById(long id) {
        Article article = articlesRepository.findArticleById(id);
        return ArticleDto.from(article);
    }

    public void deleteArticleById(long id) {
        articlesRepository.deleteById(id);
    }
}

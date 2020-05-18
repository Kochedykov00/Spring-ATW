package com.example.demo.services;

import com.example.demo.dto.ArticleDto;

import java.util.List;

public interface ArticleService {


    public List<ArticleDto> getArticlesByIdUser(long id);
    public ArticleDto getArticleById(long id);
    public void deleteArticleById(long id);
}

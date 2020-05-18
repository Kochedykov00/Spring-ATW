/*
package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ArticleSearchResult;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    ArticlesRepository articlesRepository;

    public ArticleSearchResult search(String name, int rating) {

        List<Article> pageResult =  articlesRepository.search(name);
        return ArticleSearchResult.builder()
                .articleDtos(pageResult)
                .build();

    }
}
*/

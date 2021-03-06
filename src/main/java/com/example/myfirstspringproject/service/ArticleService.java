package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {

    public List<ArticleDto> getArticles ();
    public ArticleDto getArticleById (long id);
    public void createArticle(ArticleDto articleDto, User user);
    public List<ArticleDto> getArticlesByIdBlog(long id);

}

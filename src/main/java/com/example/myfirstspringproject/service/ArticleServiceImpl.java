package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import com.example.myfirstspringproject.util.FileStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static com.example.myfirstspringproject.dto.ArticleDto.from;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    ArticlesRepository articlesRepository;

    @Autowired
    FileStorageUtil fileStorageUtil;


    public List<ArticleDto> getArticles () {
        List<Article> articles = articlesRepository.findAll();
        return from(articles);
    }

    public ArticleDto getArticleById (long id) {
        Article article = articlesRepository.findArticleById(id);
        return from(article);
    }

    public Article getArticle(Long id) {
        Article article = articlesRepository.findArticleById(id);
        return article;
    }

    public List<ArticleDto> getTop5ArticlesByDate() {
        List<Article> articles = articlesRepository.findTop5ArticlesByDate();
        return from(articles);
    }

    public List<ArticleDto> getTop5ArticlesByRating() {
        List<Article> articles = articlesRepository.findTop5ArticlesByRating();
        return from(articles);
    }

    public List<ArticleDto> getArticlesByIdBlog(long id) {
        List<Article> articles = articlesRepository.findArticlesByBlogId(id);
        return from(articles);
    }

    public void createArticle(ArticleDto articleDto, User user) {
        Date date = new Date();
        Article article = Article.builder()
                .date(date)
                .rating(0)
                .text(articleDto.getText())
                .title(articleDto.getTitle())
                .user(user)
                .blog(user.getBlog())
                .photo(articleDto.getPhoto())
                .build();
        articlesRepository.save(article);
    }

    public void plus(ArticleDto articleDto) {
        Article article = articlesRepository.findArticleById(articleDto.getId());
        Date date = new Date();
        Article article1 = Article.builder()
                .date(date)
                .id(article.getId())
                .rating(articleDto.getRating())
                .text(articleDto.getText())
                .title(articleDto.getTitle())
                .user(article.getUser())
                .blog(article.getBlog())
                .photo(articleDto.getPhoto())
                .build();
        articlesRepository.save(article1);
    }

}

package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {

    @Override
     List<Article> findAll();
     Article findArticleById(long id);




    @Query(value = "SELECT * FROM article order  by id desc LIMIT 5",
            nativeQuery = true)
    List<Article> findTop5ArticlesByDate();

    @Query(value = "SELECT * FROM article order  by rating desc LIMIT 5",
            nativeQuery = true)
    List<Article> findTop5ArticlesByRating();

    @Query(value = "SELECT * FROM article where blog_id = ?", nativeQuery = true)
    List<Article> findArticlesByBlogId(long id);

}

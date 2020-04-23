package com.example.articleservice.repositories;


import com.example.articleservice.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    List<Article> findAll();
    Article findArticleById(long id);

    @Query(value = "SELECT * FROM article order  by id desc LIMIT 5",
            nativeQuery = true)
    List<Article> findTop5ArticlesByDate();

    @Query(value = "SELECT * FROM article order  by rating desc LIMIT 5",
            nativeQuery = true)
    List<Article> findTop5ArticlesByRating();

}

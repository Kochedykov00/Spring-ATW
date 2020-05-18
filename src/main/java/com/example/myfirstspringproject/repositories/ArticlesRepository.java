package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

   /* @Query(value = "from Article article where " +
            "upper(article.title) like concat('%', upper(:query), '%') or " +
            "upper(article.rating) like concat('%', upper(:query), '%')", nativeQuery = true)
    List<Article> search(@Param("query") String query);
*/}

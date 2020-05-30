package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Comment;
import com.example.myfirstspringproject.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



    public interface LikesRepository extends JpaRepository<Like, Long> {

        Long findAllByArticleId(Long article_id);

        @Query(value = "select * from likes where article_id = ? and user_id = ?", nativeQuery = true)
        List<Like> isLikeByArticleIdAndUserId(long article_id, long user_id);


    }

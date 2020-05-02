package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {



    @Query(value = "select * from comments where article_id = ?", nativeQuery = true)
    List<Comment> listOfCommentByArticle (long id);



}

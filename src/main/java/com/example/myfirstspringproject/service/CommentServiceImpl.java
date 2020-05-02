package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.CommentDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Comment;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> getComments(long id) {

        List<Comment> comments = commentsRepository.listOfCommentByArticle(id);
        return comments;

    }

    public void createComment(CommentDto commentDto, User user, Article article) {
        Date date = new Date();
        Comment comment = Comment.builder()
                .date(date)
                .text(commentDto.getText())
                .user(user)
                .article(article)
                .build();
        commentsRepository.save(comment);
    }
}

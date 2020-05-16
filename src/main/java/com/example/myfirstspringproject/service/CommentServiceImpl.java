package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.CommentDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Comment;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import com.example.myfirstspringproject.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

import static com.example.myfirstspringproject.dto.CommentDto.from;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    ArticlesRepository articlesRepository;


    public List<CommentDto> getComments(long id) {
        List<Comment> comments = commentsRepository.listOfCommentByArticle(id);
        return from(comments);
    }

    public void createComment(CommentDto commentDto, User user, ArticleDto article) {
        Date date = new Date();
        Article article1 = articlesRepository.findArticleById(article.getId());
        Comment comment = Comment.builder()
                .date(date)
                .username(user.getUsername())
                .text(commentDto.getText())
                .user(user)
                .article(article1)
                .build();
        commentsRepository.save(comment);
    }
}

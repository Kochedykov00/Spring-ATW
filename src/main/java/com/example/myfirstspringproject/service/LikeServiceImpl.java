package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Like;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikesRepository likesRepository;

    public Long getAllByArticleId(long id) {

        Long count = likesRepository.findAllByArticleId(id);
        return count;
    }

    public Boolean isLikeByArticleIdAndUserId(long article_id, long user_id) {
        List<Like> likes = likesRepository.isLikeByArticleIdAndUserId(article_id, user_id);
        Boolean check = true;

        if (likes.size() != 0) {
            check = false;
        }
        return check;
    }

    public void doLike (Article article, User user) {
        Like like = Like.builder()
                .article(article)
                .user(user)
                .build();
        likesRepository.save(like);
    }
}

package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.User;

public interface LikeService {

    Long getAllByArticleId(long id);
    Boolean isLikeByArticleIdAndUserId(long article_id, long user_id);
    public void doLike (Article article, User user);

}

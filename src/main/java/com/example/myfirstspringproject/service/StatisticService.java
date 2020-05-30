package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.User;

public interface StatisticService {
    void save(Article article, int likes);
}

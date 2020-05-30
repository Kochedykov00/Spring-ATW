package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Statistic;
import com.example.myfirstspringproject.repositories.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public void save(Article article, int likes) {
        Statistic statistic = Statistic.builder().article(article).likes(likes).build();
        statisticRepository.save(statistic);
    }
}

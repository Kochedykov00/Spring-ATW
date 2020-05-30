package com.example.myfirstspringproject.shedulers;



import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Role;
import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import com.example.myfirstspringproject.repositories.UsersRepository;
import com.example.myfirstspringproject.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Configuration
@EnableScheduling
@Slf4j
public class PartnerStatisticSchedulers {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Transactional
    @Scheduled(cron = "0 */1 * * * *")
    public void run() {
        List<Article> articles = articlesRepository.findAll();
        for (Article article : articles) {
            statisticService.save(article , article.getRating());
        }
    }
}

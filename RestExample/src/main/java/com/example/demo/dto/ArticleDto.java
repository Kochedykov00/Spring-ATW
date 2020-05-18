package com.example.demo.dto;


import com.example.demo.models.Article;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArticleDto {

    private Long id;
    private User user;
    String title;
    String text;
    int rating;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .user(article.getUser())
                .title(article.getTitle())
                .text(article.getText())
                .rating(article.getRating())
                .build();
    }

    public static List<ArticleDto> from(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }

}

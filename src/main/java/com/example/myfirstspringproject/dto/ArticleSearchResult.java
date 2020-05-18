package com.example.myfirstspringproject.dto;


import com.example.myfirstspringproject.models.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleSearchResult {

    private List<Article> articleDtos;

}

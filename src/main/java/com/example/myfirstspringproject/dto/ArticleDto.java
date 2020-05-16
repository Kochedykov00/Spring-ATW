package com.example.myfirstspringproject.dto;


import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

   private String title;
   private String text;
   private String photo;
   private Long id;
   private Long blog_id;
   private int rating;
   private Long user_id;
   private Date date;

   public static List<ArticleDto> from(List<Article> articles) {
      List<ArticleDto> articleDtos = new ArrayList<>();
      for (Article article : articles) {

         ArticleDto articleDto = ArticleDto.builder()
                 .id(article.getId())
                 .text(article.getText())
                 .title(article.getTitle())
                 .user_id(article.getUser().getId())
                 .blog_id(article.getBlog().getId())
                 .rating(article.getRating())
                 .photo(article.getPhoto())
                 .date(article.getDate())
                 .build();
         articleDtos.add(articleDto);
      }
      return articleDtos;
   }

   public static ArticleDto from(Article article) {


         ArticleDto articleDto = ArticleDto.builder()
                 .id(article.getId())
                 .text(article.getText())
                 .title(article.getTitle())
                 .user_id(article.getUser().getId())
                 .blog_id(article.getBlog().getId())
                 .rating(article.getRating())
                 .photo(article.getPhoto())
                 .date(article.getDate())
                 .build();

         return articleDto;
   }
}

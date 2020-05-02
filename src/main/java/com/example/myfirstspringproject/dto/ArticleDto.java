package com.example.myfirstspringproject.dto;


import lombok.Data;

@Data
public class ArticleDto {

   private String title;
   private String text;
   private String photo;
   private Long id;
}

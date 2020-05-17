
package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public interface BlogService {



   void createBlog(BlogDto blogDto, User user);
   public List<BlogDto> getBlogByIdUser(long id);
   public Blog getBlogById(long id);



}

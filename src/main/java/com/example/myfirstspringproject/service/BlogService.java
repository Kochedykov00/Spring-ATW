
package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public interface BlogService {


   List<Blog> getBlogs (long id);
   List<Article> getArticlesByIdBlog(long id);
   void createBlog(BlogDto blogDto, User user);



}

/*package com.example.myfirstspringproject.service;



import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    BlogsRepository blogsRepository;


    public List<Blog> getBlogs (long id) {
        List<Blog> blogs = blogsRepository.findBlogsByIdUser(id);
        return blogs;
    }


    public List<Article> getArticlesByIdBlog(long id) {
        List<Article> articles = blogsRepository.findArticlesByBlogId(id);
        return articles;
    }

    public void createBlog(BlogDto blogDto, User user) {
        Blog blog = Blog.builder()
                .title(blogDto.getTitle())
                .description(blogDto.getDescription())
                .user(user)
                .build();
        blogsRepository.save(blog);
    }


}
*/
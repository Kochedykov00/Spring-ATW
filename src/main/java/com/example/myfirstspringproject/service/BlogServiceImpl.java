package com.example.myfirstspringproject.service;



import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.BlogsRepository;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.myfirstspringproject.dto.BlogDto.from;
import static com.example.myfirstspringproject.dto.ArticleDto.from;

@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    BlogsRepository blogsRepository;

    @Autowired
    UsersRepository usersRepository;




    public List<BlogDto> getBlogByIdUser(long id) {
        List<Blog> blogs = blogsRepository.findBlogsByIdUser(id);
        return from(blogs);
    }

    public Blog getBlogById(long id) {
        Blog blog = blogsRepository.findBlogById(id);
        return blog;
    }



    public void createBlog(BlogDto blogDto, User user) {
        Blog blog = Blog.builder()
                .title(blogDto.getTitle())
                .description(blogDto.getDescription())
                .user(user)
                .build();
        blogsRepository.save(blog);


        User userChange = User.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .info(user.getInfo())
                .photo(user.getPhoto())
                .email(user.getEmail())
                .id(user.getId())
                .confirmCode(user.getConfirmCode())
                .hashPassword(user.getHashPassword())
                .createdAt(user.getCreatedAt())
                .role(user.getRole())
                .state(user.getState())
                .blog(blog)
                .build();
        usersRepository.save(userChange);
    }


}

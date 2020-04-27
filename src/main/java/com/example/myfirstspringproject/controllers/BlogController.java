/*
package com.example.myfirstspringproject.controllers;


import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {



    @Autowired
    BlogService blogService;



    @GetMapping("/user/{user-id}")
    public String getBlogs (@PathVariable("user-id") Long id, Model model) {
        List<Blog> blogs = blogService.getBlogs(id);
        model.addAttribute("blogs", blogs);
        return "blog";
    }

    @GetMapping("/{blog-id}")
    public String getArticles(@PathVariable("blog-id") Long id, Model model) {
        List<Article> articles = blogService.getArticlesByIdBlog(id);
        model.addAttribute("articles", articles);
        return "articles_of_blog";
    }

    @GetMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String getCreateBlog() {
        return "creating_blog";
    }

    @PostMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String createArticle(Authentication authentication, BlogDto blogDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        blogService.createBlog(blogDto,userDetails.getUser());
        return "redirect:/";
    }



}
*/
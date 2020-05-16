package com.example.myfirstspringproject.controllers;



import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/blog")
@Controller
public class BlogController {



    @Autowired
    BlogService blogService;



    @GetMapping("/{blog-id}")
    public String getBlogs (@PathVariable("blog-id") Long id, Model model) {
        List<BlogDto> blogs = blogService.getBlogs(id);
        List<ArticleDto> articleDtos = blogService.getArticlesByIdBlog(id);
        model.addAttribute("blogs", blogs);
        model.addAttribute("articles", articleDtos);
        return "blog";
    }






    @GetMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String getCreateBlog() {
        return "creating_blog";
    }

    @PostMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String createBlog(Authentication authentication, BlogDto blogDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        blogService.createBlog(blogDto,userDetails.getUser());
        return "redirect:/";
    }



}

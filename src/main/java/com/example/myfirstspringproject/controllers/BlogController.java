package com.example.myfirstspringproject.controllers;



import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.ArticleService;
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

    @Autowired
    ArticleService articleService;





    @GetMapping("/{blog-id}")
    public String getBlogs (@PathVariable("blog-id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        List<ArticleDto> articleDtos = articleService.getArticlesByIdBlog(id);
        model.addAttribute("blog", blog);
        model.addAttribute("articles", articleDtos);

        return "blog";
    }








    @GetMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String getCreateBlog(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        if (user.getBlog() == null ) {
            return "creating_blog";
        }
        else {
            return "redirect:/";
        }
    }

    @PostMapping("/createBlog")
    @PreAuthorize("isAuthenticated()")
    public String createBlog(Authentication authentication, BlogDto blogDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        blogService.createBlog(blogDto,userDetails.getUser());
        return "redirect:/";
    }



}

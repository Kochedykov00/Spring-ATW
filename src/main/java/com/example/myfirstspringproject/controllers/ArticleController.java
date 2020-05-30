package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.dto.ArticleDto;
import com.example.myfirstspringproject.dto.CommentDto;
import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.ArticlesRepository;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/articles")

public class ArticleController {


    @Autowired
    ArticleServiceImpl articleService;

    @Autowired
    BlogService blogService;

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    UsersService usersService;

    @Autowired
    ArticlesRepository articlesRepository;

    @Autowired
    LikeService likeService;




    @PreAuthorize("permitAll()")
    @GetMapping
    public String getArticles (Model model, Authentication authentication) {
      List<ArticleDto> articlesByDate = articleService.getTop5ArticlesByDate();
      List<ArticleDto> articlesByRating = articleService.getTop5ArticlesByRating();
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      User current_user = userDetails.getUser();
        model.addAttribute("articlesByDate", articlesByDate);
        model.addAttribute("articlesByRating", articlesByRating);
        model.addAttribute("current_user", current_user);
        return "articles";
    }

    @GetMapping("/{article-id}")
    public String getConcreteFilm(@PathVariable("article-id") Long id, Model model) {
        ArticleDto article = articleService.getArticleById(id);
        List <CommentDto> comments = commentService.getComments(id);
        //Long likes = likeService.getAllByArticleId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("article", article);
        //model.addAttribute("likes", likes);

        return "article";
    }


        @PostMapping("/{article-id}")
        @PreAuthorize("isAuthenticated()")
        public String createPlus (@RequestParam(required = false, name="rating") String rating, @PathVariable("article-id") Long id, Authentication authentication, CommentDto commentDto){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User current_user = userDetails.getUser();
        Article current_article = articlesRepository.findArticleById(id);
        ArticleDto article = articleService.getArticleById(id);
        if (rating != null && likeService.isLikeByArticleIdAndUserId(article.getId(), current_user.getId())) {
            article.setRating(article.getRating() + 1);
            likeService.doLike(current_article, current_user);
            articleService.plus(article);
        }
        else {
            commentService.createComment(commentDto, userDetails.getUser(), article);
        }
        return "redirect:/articles/{article-id}";

    }






    @GetMapping("/createArticle")
    @PreAuthorize("isAuthenticated()")
    public String getCreateArticlePage(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        if (blogService.getBlogByIdUser(user.getId()) != null) {
            return "creating_article";
        }

        else {
            return "redirect:/blog/createBlog";
        }
    }

    @PostMapping("/createArticle")
    @PreAuthorize("isAuthenticated()")
    public String createArticle( Authentication authentication, ArticleDto articleDto) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        articleService.createArticle(articleDto,userDetails.getUser());
        return "redirect:/";
    }

}

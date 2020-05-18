package com.example.demo.controllers;


import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.UserDto;
import com.example.demo.services.ArticleService;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class UsersController {

        @Autowired
        private UsersService usersService;

        @Autowired
        private ArticleService articleService;

        @PreAuthorize("isAuthenticated()")
        @GetMapping("/users")
        public ResponseEntity<List<UserDto>> getUsers() {
            return ResponseEntity.ok(usersService.getAllUsers());
        }

        @PreAuthorize("hasAuthority('ADMIN')")
        @DeleteMapping("/users/{user-id}")
        public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long userId) {
            usersService.deleteUser(userId);
            return ResponseEntity.accepted().build();
        }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/{user-id}/articles")
    public ResponseEntity<List<ArticleDto>> getArticlesOfUser(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(articleService.getArticlesByIdUser(userId));
    }
    }



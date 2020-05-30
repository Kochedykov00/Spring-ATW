package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.dto.UsersSearchResult;
import com.example.myfirstspringproject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/function_search")
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping("/search")
    public UsersSearchResult searchExercises(
            @RequestParam("query") String query,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return service.searchUsers(query, page, size);
    }
}

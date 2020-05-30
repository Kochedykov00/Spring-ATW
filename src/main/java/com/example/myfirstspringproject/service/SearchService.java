
package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.UsersSearchResult;

public interface SearchService {

    public UsersSearchResult searchUsers(String query, Integer page, Integer size);
}


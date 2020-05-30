package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.dto.UsersSearchResult;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersSearchResult searchUsers(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> pageResult = usersRepository.search(query, pageRequest);
        List<UserDto> users = UserDto.from(pageResult.getContent());
        return UsersSearchResult.builder()
                .users(users)
                .count(pageResult.getTotalPages())
                .build();
    }
}

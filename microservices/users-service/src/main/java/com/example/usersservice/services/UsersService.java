package com.example.usersservice.services;

import com.example.usersservice.dto.UserDto;
import com.example.usersservice.models.User;
import com.example.usersservice.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.usersservice.dto.UserDto.from;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }


}

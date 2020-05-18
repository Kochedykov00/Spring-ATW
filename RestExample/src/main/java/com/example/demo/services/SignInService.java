package com.example.demo.services;


import com.example.demo.dto.SignInDto;
import com.example.demo.dto.TokenDto;

public interface SignInService {
        TokenDto signIn(SignInDto signInData);
    }



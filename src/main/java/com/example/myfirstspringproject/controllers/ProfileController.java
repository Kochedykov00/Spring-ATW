package com.example.myfirstspringproject.controllers;


import com.example.myfirstspringproject.dto.BlogDto;
import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.BlogService;
import com.example.myfirstspringproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    UsersService usersService;

    @Autowired
    BlogService blogService;



    @GetMapping("/{user-id}")
    @PreAuthorize("isAuthenticated()")
    public String getProfile(@PathVariable("user-id") Long id, Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User myPage = userDetails.getUser();
        UserDto user = usersService.getConcreteUser(id);
        List<BlogDto> blogDtos = blogService.getBlogByIdUser(id);
        model.addAttribute("blog", blogDtos);
        model.addAttribute("user", user);
        model.addAttribute("myPage", myPage);
        return "profile";
    }


}

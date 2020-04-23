package com.example.usersservice.controllers;

import com.example.usersservice.dto.UserDto;
import com.example.usersservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;




    @GetMapping
    public String getUsersPage(@CookieValue(value = "AuthCookie", required = false) String cookie,
                               Model model) throws NullPointerException {


            List<UserDto> users = usersService.getUsers();
            model.addAttribute("users", users);
            return "users_page";

    }
}

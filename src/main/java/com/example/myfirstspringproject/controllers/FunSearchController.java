package com.example.myfirstspringproject.controllers;


import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FunSearchController {

    @GetMapping("/function_search")
    public String getAuthorsPage(Authentication authentication,Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "search";
    }

}

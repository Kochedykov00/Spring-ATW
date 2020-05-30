package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ChatController {
    @GetMapping("/chating")
    public String getIndexPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User current = userDetails.getUser();
        model.addAttribute("user", current);
        model.addAttribute("pageId", UUID.randomUUID().toString());
        return "index";
    }
}


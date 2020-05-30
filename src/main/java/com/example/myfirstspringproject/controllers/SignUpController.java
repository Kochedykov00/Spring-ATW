package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.dto.SignUpDto;
import com.example.myfirstspringproject.dto.SignUpForm;
import com.example.myfirstspringproject.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class SignUpController {


    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model, Authentication authentication) {
        model.addAttribute("form", new SignUpForm());
        if(authentication != null) {
            return "redirect:/";
        } else {
            return "sign_up";
        }
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute("form") SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(form);
            System.out.println("ERRORS: " + bindingResult.getAllErrors());
            model.addAttribute("form", form);
            return "sign_up";
        } else {
            service.signUp(form);
            return "redirect:/signIn";
        }
    }
}

package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.security.config.jwt.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class ProfileController {

        @PreAuthorize("isAuthenticated()")
        @GetMapping("/self")
        // TODO: сделать через getSelf(@AuthenticationPrincipal UserDetailsImpl) + 10 баллов к экзамену первому
        public ResponseEntity<UserDto> getSelf() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();
            System.out.println(userDetails);
            return ResponseEntity.ok(UserDto.builder()
                    .name(userDetails.getUsername())
                    .id(userDetails.getUserId())
                    .build());
        }
    }



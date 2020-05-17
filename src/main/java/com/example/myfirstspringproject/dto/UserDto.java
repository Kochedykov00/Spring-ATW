package com.example.myfirstspringproject.dto;

import com.example.myfirstspringproject.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String hashPassword;
    private String photo;
    private String info;
    private Long id;
    private long blog_id;

    public static UserDto from(User user) {
        if (user.getBlog() != null) {
            return UserDto.builder()
                    .id(user.getId())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .info(user.getInfo())
                    .blog_id(user.getBlog().getId())
                    .photo(user.getPhoto())
                    .build();
        } else {
            return UserDto.builder()
                    .id(user.getId())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .info(user.getInfo())
                    .photo(user.getPhoto())
                    .build();
        }
    }

    public static UserDto fromEdit(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }


    public static List<UserDto> fromSearch(List<User> user) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1 : user) {
            UserDto userDto = UserDto.builder()
                    .id(user1.getId())
                    .firstname(user1.getFirstname())
                    .lastname(user1.getLastname())
                    .username(user1.getUsername())
                    .email(user1.getEmail())
                    .photo(user1.getPhoto())
                    .info(user1.getInfo())
                    .build();
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::fromEdit)
                .collect(Collectors.toList());
    }
}




package com.example.myfirstspringproject.dto;


import com.example.myfirstspringproject.models.User;
import lombok.Data;

@Data
public class BlogDto {


    private String title;
    private String description;
    private Long id;

}



package com.example.myfirstspringproject.dto;


import com.example.myfirstspringproject.models.Article;
import com.example.myfirstspringproject.models.Blog;
import com.example.myfirstspringproject.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto {


    private String title;
    private String description;
    private Long id;
    private Long user_id;


    public static List<BlogDto> from(List<Blog> blogs) {
        List<BlogDto> blogDtos = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogDto blogDto = BlogDto.builder()
                    .id(blog.getId())
                    .title(blog.getTitle())
                    .description(blog.getDescription())
                    .user_id(blog.getUser().getId())
                    .build();
            blogDtos.add(blogDto);
        }
        return blogDtos;

    }
}

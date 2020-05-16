package com.example.myfirstspringproject.dto;


import com.example.myfirstspringproject.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private String text;
    private Long user_id;
    private Long id;
    private Long article_id;
    private Date date;
    private String username;


    public static List <CommentDto> from(List<Comment> comments) {
        List<CommentDto> comments1 = new ArrayList<>();
        for (Comment comment : comments) {

            CommentDto commentDto = CommentDto.builder()
                    .id(comment.getId())
                    .text(comment.getText())
                    .username(comment.getUsername())
                    .user_id(comment.getUser().getId())
                    .article_id(comment.getArticle().getId())
                    .date(comment.getDate())
                    .build();
            comments1.add(commentDto);
        }
        return comments1;
    }
}

package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.CommentDto;
import com.example.myfirstspringproject.models.Comment;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments(long id);

}

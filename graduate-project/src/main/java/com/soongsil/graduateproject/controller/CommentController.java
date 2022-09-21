package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.dto.CommentSaveDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @PostMapping("/posts/{boardId}/comments/{commentId}")
    public void save(@PathVariable Long boardId, @PathVariable Long commentId, CommentSaveDto commentSaveDto) {

    }

    @GetMapping("/posts/{boardId}/comments")
    public String list(@PathVariable Long boardId) {
        return "hello";
    }
}

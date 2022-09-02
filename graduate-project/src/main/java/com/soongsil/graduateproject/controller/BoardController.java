package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Board;
import com.soongsil.graduateproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/posts")
    public String list(Model model) {
        List<Board> boardList = boardService.findBoardsAll();
        model.addAttribute("boardList", boardList);
        return "board/posts";
    }

    @GetMapping("/posts/write")
    public String writeForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "board/postsWrite";
    }
}

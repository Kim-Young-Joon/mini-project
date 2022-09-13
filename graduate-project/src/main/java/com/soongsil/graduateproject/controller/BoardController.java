package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Board;
import com.soongsil.graduateproject.dto.BoardSaveDto;
import com.soongsil.graduateproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("boardSaveDto", new BoardSaveDto());
        return "board/postsWrite";
    }

    @PostMapping("posts/write")
    public String writeBoard() {
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String detailView() {
        return "";
    }
}

package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Board;
import com.soongsil.graduateproject.dto.BoardGetDto;
import com.soongsil.graduateproject.dto.BoardPostDto;
import com.soongsil.graduateproject.dto.BoardSearchCond;
import com.soongsil.graduateproject.service.BoardService;
import com.soongsil.graduateproject.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/posts")
    public String list(Model model, @ModelAttribute BoardSearchCond condition, @RequestParam(defaultValue = "1") long page) {
        List<Board> boardList = boardService.findList(condition, page);
        model.addAttribute("boardList", boardList);
        return "board/posts";
    }

    @GetMapping("/posts/write")
    public String writeForm(Model model) {
        model.addAttribute("boardForm", new BoardPostDto());
        return "board/postsWrite";
    }

    @PostMapping("/posts/write")
    public String write(@Valid @ModelAttribute BoardPostDto boardPostDto, BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "board/postsWrite";
        }

        HttpSession session = request.getSession(false);
        if(session != null){
            Long memberId = (Long) session.getAttribute(SessionConst.LOGIN_MEMBER);
            boardService.post(memberId, boardPostDto.getTitle(), boardPostDto.getContent());
        }
        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String findOne(@PathVariable Long id, Model model) {
        Board board = boardService.findOne(id);
        BoardGetDto boardGetDto = new BoardGetDto(board);
        model.addAttribute("boardDto", boardGetDto);
        return "board/board";
    }

    @PostMapping("/posts/{id}")
    public String viewComment() {
        // 댓글 DB 에서 가져와서 view 단으로 model 에 담아서 보내기
        return "";
    }
}

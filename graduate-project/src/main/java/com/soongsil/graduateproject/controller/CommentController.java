package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Comment;
import com.soongsil.graduateproject.dto.CommentPostDto;
import com.soongsil.graduateproject.dto.CommentSaveDto;
import com.soongsil.graduateproject.service.CommentService;
import com.soongsil.graduateproject.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{boardId}/comments")
    public void save(@PathVariable Long boardId, CommentSaveDto commentSaveDto, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long memberId = (Long) session.getAttribute(SessionConst.LOGIN_MEMBER);
            commentService.save(memberId, boardId, commentSaveDto.getContent());
        }
    }

    @GetMapping("/posts/{boardId}/comments")
    public List<CommentPostDto> list(@PathVariable Long boardId) {
        List<Comment> findComments = commentService.findCommentListByBoardId(boardId);
        List<CommentPostDto> comments = findComments.stream()
                .map(m -> new CommentPostDto(m.getMember().getName(), m.getContent()))
                .collect(Collectors.toList());
        return comments;
    }
}

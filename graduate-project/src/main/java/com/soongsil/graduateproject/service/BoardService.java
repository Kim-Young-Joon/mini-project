package com.soongsil.graduateproject.service;

import com.soongsil.graduateproject.domain.Board;
import com.soongsil.graduateproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findBoardsAll() {
        List<Board> list = boardRepository.findAll();
        return list;
    }

    public void save(Board board) {
        boardRepository.save(board);
    }
}

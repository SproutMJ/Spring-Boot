package com.springboot.demo.service;

import com.springboot.demo.config.exception.MemberNotFoundException;
import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.Member;
import com.springboot.demo.dto.BoardDto;
import com.springboot.demo.repository.BoardRepository;
import com.springboot.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public List<BoardDto> findAllBoards() {

        return (List<BoardDto>) boardRepository.findAll().stream().map(
                b->BoardDto.builder().text(b.getText()).text(b.getText()).like(b.getLike()).build());
    }

    public void createBoard(BoardDto boardDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member author = memberRepository.findByUsername(authentication.getName()).orElseThrow(MemberNotFoundException::new);

        boardRepository.save(Board.builder()
                .member(author)
                .title(boardDto.getTitle())
                .text(boardDto.getText())
                .like(boardDto.getLike()).build());
    }

    public BoardDto findById(Long id) {
        Board board = boardRepository.findById(id).get();
        return BoardDto.builder().title(board.getTitle()).text(board.getText()).build();
    }

    public void updateBoard(Long id, BoardDto updateBoardDto) {
        Board board = boardRepository.findById(id).get();
        board.setText(updateBoardDto.getText());
        board.setTitle(updateBoardDto.getTitle());
    }

    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        boardRepository.delete(board);
    }

    public BoardDto findByTitle(String title) {
        Board board = boardRepository.findByTitle(title).get();
        return BoardDto.builder().title(board.getTitle()).text(board.getText()).like(board.getLike()).build();
    }

    public void likeBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        board.setLike(board.getLike() + 1L);
    }

    public void favoriteBoard(Long id) {
        //todo
    }
}

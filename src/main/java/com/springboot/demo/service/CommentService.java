package com.springboot.demo.service;

import com.springboot.demo.config.exception.MemberNotFoundException;
import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.comment.Comment;
import com.springboot.demo.domain.member.Member;
import com.springboot.demo.dto.CommentDto;
import com.springboot.demo.repository.BoardRepository;
import com.springboot.demo.repository.CommentRepository;
import com.springboot.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private CommentRepository commentRepository;
    private BoardRepository boardRepository;
    private MemberRepository memberRepository;

    public List<CommentDto> findCommentsByBoardId(Long boardId) {
        Board targetBoard = boardRepository.findById(boardId).get();
        List<Comment> comments = commentRepository.findAllByBoard(targetBoard);
        final String nickName = targetBoard.getMember().getNickName();
        return comments.stream().map(
                c->CommentDto.builder().comment(c.getComment()).author(nickName).build()
        ).collect(Collectors.toList());
    }

    public void createCommentInBoard(Long boardId, String comment) {
        Board targetBoard = boardRepository.findById(boardId).get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member author = memberRepository.findByUsername(authentication.getName()).orElseThrow(MemberNotFoundException::new);
        Comment commentObj = Comment.builder().comment(comment).board(targetBoard).member(author).build();
        commentRepository.save(commentObj);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
    }
}

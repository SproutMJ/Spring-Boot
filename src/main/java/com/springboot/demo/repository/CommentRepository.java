package com.springboot.demo.repository;

import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByBoard(Board target);
}

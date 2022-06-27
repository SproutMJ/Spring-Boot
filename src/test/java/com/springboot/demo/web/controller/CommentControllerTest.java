package com.springboot.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {
    @InjectMocks
    private CommentController commentController;

    @Mock
    private CommentService commentService;

    private ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    private void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    void findCommentAtBoard() throws Exception {
        Long boardId = 1L;
        mockMvc.perform(get("/api/comments")
                        .param("boardId", String.valueOf(boardId)))
                .andExpect(status().isOk());

        verify(commentService).findCommentsByBoardId(boardId);
    }

    @Test
    void createCommentAtBoard() throws Exception {
        Long boardId = 1L;
        String comment = "test";
        mockMvc.perform(post("/api/comments")
                        .param("boardId", String.valueOf(boardId))
                        .param("comment", comment))
                .andExpect(status().isCreated());

        verify(commentService).createCommentInBoard(boardId, comment);
    }

    @Test
    void deleteComment() throws Exception {
        Long commentId = 1L;
        mockMvc.perform(delete("/api/comments/{commentId}", commentId))
                .andExpect(status().isOk());

        verify(commentService).deleteComment(commentId);
    }
}
package com.springboot.demo.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.dto.BoardDto;
import com.springboot.demo.service.BoardService;
import com.springboot.demo.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    @InjectMocks
    private BoardController boardController;

    @Mock
    private BoardService boardService;

    @Mock
    private MemberService memberService;

    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    void findAllBoards() throws Exception {
        mockMvc.perform(get("/api/boards"))
                .andExpect(status().isOk());

        verify(boardService).findAllBoards();
    }

    @Test
    void createBoard() throws Exception {
        BoardDto boardDto = BoardDto.builder().title("test").text("text").like(0L).build();

        mockMvc.perform(post("/api/boards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(boardDto)))
                .andExpect(status().isCreated());

        verify(boardService).createBoard(refEq(boardDto));
    }

    @Test
    void findBoard() throws Exception {
        Long testId = 1L;

        mockMvc.perform(get("/api/boards/{id}", testId))
                .andExpect(status().isOk());

        verify(boardService).findById(testId);
    }

    @Test
    void updateBoard() throws Exception {

        Long testId = 1L;
        BoardDto boardDto = BoardDto.builder().title("test").text("text").like(0L).build();

        mockMvc.perform(put("/api/boards/{id}", testId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(boardDto)))
                .andExpect(status().isOk());

        verify(boardService).updateBoard(refEq(testId), refEq(boardDto));
    }

    @Test
    void deleteBoard() throws Exception {
        Long testId = 1L;

        mockMvc.perform(delete("/api/boards/{id}", testId))
                .andExpect(status().isOk());

        verify(boardService).deleteBoard(testId);
    }

    @Test
    void searchBoards() throws Exception {
        String title = "test";
        Long page = Long.valueOf(2);

        mockMvc.perform(get("/api/boards/search")
                        .param("title", title)
                        .param("page", String.valueOf(page)))
                .andExpect(status().isOk());

        verify(boardService).findByTitle(refEq(title), refEq(page));
    }

    @Test
    void like() throws Exception {
        Long testId = 1L;

        mockMvc.perform(post("/api/boards/{id}/like", testId))
                .andExpect(status().isOk());

        verify(boardService).likeBoard(testId);
    }

    @Test
    void favorite() {
    }
}
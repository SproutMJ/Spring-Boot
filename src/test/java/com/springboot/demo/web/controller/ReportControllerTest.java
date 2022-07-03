package com.springboot.demo.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.dto.report.BoardReportDto;
import com.springboot.demo.dto.report.MemberReportDto;
import com.springboot.demo.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ReportControllerTest {
    @InjectMocks
    private ReportController reportController;

    @Mock
    private ReportService reportService;

    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(reportController).build();
    }

    @Test
    void reportBoard() throws Exception {
        BoardReportDto boardReportDto = BoardReportDto.builder()
                .title("test")
                .reason("reason")
                .reporter(null)
                .accusedPerson(null)
                .accusedBoard(null)
                .build();

        mockMvc.perform(post("/api/reports/boards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(boardReportDto)))
                .andExpect(status().isCreated());

        //verify(reportService).reportBoard(boardReportDto);
    }

    @Test
    void reportUser() throws Exception {
        MemberReportDto memberReportDto = MemberReportDto.builder()
                .title("test")
                .reason("reason")
                .reporter(null)
                .accusedPerson(null)
                .build();

        mockMvc.perform(post("/api/reports/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(memberReportDto)))
                .andExpect(status().isCreated());

        //verify(reportService).reportUser(memberReportDto);

    }
}
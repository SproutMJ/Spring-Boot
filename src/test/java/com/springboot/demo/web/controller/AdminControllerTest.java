package com.springboot.demo.web.controller;

import com.springboot.demo.service.AdminService;
import com.springboot.demo.service.BoardService;
import com.springboot.demo.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @Mock
    private MemberService memberService;

    @Mock
    private BoardService boardService;

    MockMvc mockMvc;

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }


    @Test
    void adminInfo() throws Exception {
        mockMvc.perform(get("/api/admin"))
                .andExpect(status().isOk());

        verify(adminService).findInfo();
    }

    @Test
    void registeredUsers() throws Exception {
        mockMvc.perform(get("/api/admin/analysis/users"))
                .andExpect(status().isOk());

        verify(adminService).findAllUsers();
    }

    @Test
    void registeredBoards() throws Exception {
        mockMvc.perform(get("/api/admin/analysis/boards"))
                .andExpect(status().isOk());

        verify(adminService).findAllBoards();
    }

    @Test
    void reportedUsers() throws Exception {
        mockMvc.perform(get("/api/admin/reports/users"))
                .andExpect(status().isOk());

        verify(adminService).findAllReportedUsers();
    }

    @Test
    void reportedBoards() throws Exception {
        mockMvc.perform(get("/api/admin/reports/boards"))
                .andExpect(status().isOk());

        verify(adminService).findAllReportedBoards();
    }
}
package com.springboot.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.domain.member.Member;
import com.springboot.demo.domain.member.auth.Authority;
import com.springboot.demo.dto.LoginRequestDto;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.dto.RegisterDto;
import com.springboot.demo.dto.TokenDto;
import com.springboot.demo.repository.MemberRepository;
import com.springboot.demo.service.MemberService;
import com.springboot.demo.service.auth.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.refEq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    MemberService memberService;

    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @DisplayName("모든 유저 조회")
    @Test
    void findAllUsers() throws Exception {
        // when then
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk());
        verify(memberService).findAll();
    }

    @DisplayName("유저 조회")
    @Test
    void findUsers() throws Exception {
        // given
        Long testId = 1L;
        mockMvc.perform(get("/api/users/{id}", testId))
                .andExpect(status().isOk());

        // when then
        verify(memberService).find(testId);
    }

    @DisplayName("유저 갱신")
    @Test
    void updateUser() throws Exception {
        // given
        Long testId = 1L;
        MemberDto testDto = MemberDto.builder()
                .id(1L)
                .name("Kim")
                .nickName("KIM")
                .username("test12345")
                .password("test").build();

        // when then
        mockMvc.perform(put("/api/users/{id}", testId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(testDto)))
                .andExpect(status().isOk());

        verify(memberService).updateUser(refEq(testId), refEq(testDto));
    }

    @DisplayName("유저 삭제")
    @Test
    void deleteUser() throws Exception {
        // given
        Long testId = 1L;

        // when then
        mockMvc.perform(
                        delete("/api/users/{id}", testId))
                .andExpect(status().isOk());
        verify(memberService).deleteUser(testId);
    }

    @DisplayName("유저 즐져찾기 조회")
    @Test
    void findUserFavorites() throws Exception {
        // given
        Long testId = 1L;

        // when then
        mockMvc.perform(
                        get("/api/users/{id}/favorites", testId))
                .andExpect(status().isOk());
        verify(memberService).findUserFavorites(testId);
    }
}
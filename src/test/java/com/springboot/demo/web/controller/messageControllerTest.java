package com.springboot.demo.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.domain.message.Message;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.dto.MessageDto;
import com.springboot.demo.service.MessageService;
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
class MessageControllerTest {
    @InjectMocks
    MessageController messageController;


    @Mock
    MessageService messageService;

    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void BeforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    void sendMessage() throws Exception {
        //given
        MemberDto sender = MemberDto.builder().name("sender").nickName("sender").username("sender").password("sender").build();
        MemberDto receiver = MemberDto.builder().name("receiver").nickName("receiver").username("receiver").password("receiver").build();
        MessageDto message = MessageDto.builder().title("제목").text("내용").sender(sender).receiver(receiver).build();

        //when then
        mockMvc.perform(post("/api/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(message))
                ).andExpect(status().isOk());

        verify(messageService).sendMessage(message);

    }

    @Test
    void receivedMessageAll() throws Exception {
        //given


        //when then
        mockMvc.perform(get("/api/messages/receiver")
        ).andExpect(status().isOk());

        verify(messageService).receivedMessage();
    }

    @Test
    void receivedMessageOne() throws Exception {
        //given
        Long testId = 1L;

        //when then
        mockMvc.perform(get("/api/messages/receiver/{messageId}", testId)
        ).andExpect(status().isOk());

        verify(messageService).receivedMessage(testId);
    }

    @Test
    void deleteReceivedMessage() throws Exception {
        //given
        Long testId = 1L;

        //when then
        mockMvc.perform(delete("/api/messages/receiver/{messageId}", testId)
        ).andExpect(status().isOk());

        verify(messageService).deleteReceivedMessage(testId);
    }

    @Test
    void sendMessageAll() throws Exception {
        //given

        //when then
        mockMvc.perform(get("/api/messages/sender")
        ).andExpect(status().isOk());

        verify(messageService).sendedMessage();
    }

    @Test
    void sendMessageOne() throws Exception {
        //given
        Long testId = 1L;

        //when then
        mockMvc.perform(get("/api/messages/sender/{messageId}", testId)
        ).andExpect(status().isOk());

        verify(messageService).sendedMessage(testId);
    }

    @Test
    void deleteSendedMessage() throws Exception {
        //given
        Long testId = 1L;

        //when then
        mockMvc.perform(delete("/api/messages/sender/{messageId}", testId)
        ).andExpect(status().isOk());

        verify(messageService).deleteSendedMessage(testId);
    }
}
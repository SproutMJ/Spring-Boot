package com.springboot.demo.service;

import com.springboot.demo.domain.message.Message;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.dto.MessageDto;
import com.springboot.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author https://github.com/SproutMJ
 * @exception
 * @param
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */

@RequiredArgsConstructor
@Transactional
@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public void sendMessage(MessageDto messageDto) {
        Message message = Message.builder()
                .sender(messageDto.getSender().toEntity())
                .receiver(messageDto.getReceiver().toEntity())
                .title(messageDto.getTitle())
                .text(messageDto.getText()).build();

        messageRepository.save(message);
    }

    public List<MessageDto> receivedMessage() {
        return (List<MessageDto>) messageRepository.findAll().stream().map(m->
                MessageDto.builder().title(m.getTitle()).text(m.getText()).build());
    }

    public MessageDto receivedMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).get();
        return MessageDto.builder().title(message.getTitle()).text(message.getText()).build();
    }

    public void deleteReceivedMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).get();
        messageRepository.delete(message);
    }

    public List<MessageDto> sendedMessage() {
        return (List<MessageDto>) messageRepository.findAll().stream().map(m->
                MessageDto.builder().title(m.getTitle()).text(m.getText()).build());
    }

    public MessageDto sendedMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).get();
        return MessageDto.builder().title(message.getTitle()).text(message.getText()).build();
    }

    public void deleteSendedMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).get();
        messageRepository.delete(message);
    }
}

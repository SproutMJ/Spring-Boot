package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.dto.MessageDto;
import com.springboot.demo.service.MessageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api")
@RestController
public class messageController {
    private final MessageService messageService;

    @ApiOperation(value = "쪽지 보내기", notes = "쪽지 보내기")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/messages")
    public Response sendMessage(@ApiParam(value = "보내는 유저",required = true) @RequestBody MemberDto sender,
                                @ApiParam(value = "받는 유저",required = true) @RequestBody MemberDto receiver,
                                @ApiParam(value = "보내는 유저",required = true) @RequestBody MessageDto messageDto){
        messageService.sendMessage(sender, receiver, messageDto);
        return Response.success();
    }

    @ApiOperation(value = "받은 쪽지", notes = "받은 쪽지")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/messages/receiver")
    public Response receivedMessageAll(){
        return Response.success(messageService.receivedMessage());
    }

    @ApiOperation(value = "받은 쪽지 개별 확인", notes = "받은 쪽지 개별 확인")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/messages/receiver/{messageId}")
    public Response receivedMessageOne(@ApiParam(value = "메시지 ID",required = true) @PathVariable Long messageId){
        return Response.success(messageService.receivedMessage(messageId));
    }

    @ApiOperation(value = "받은 쪽지 삭제", notes = "받은 쪽지 삭제")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/messages/receiver/{messageId}")
    public Response deleteReceivedMessage(@ApiParam(value = "메시지 ID",required = true) @PathVariable Long messageId){
        messageService.deleteReceivedMessage(messageId);
        return Response.success();
    }

    @ApiOperation(value = "보낸 쪽지 전부 확인", notes = "보낸 쪽지 전부 확인")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/messages/sender")
    public Response sendMessageAll(){
        return Response.success(messageService.sendedMessage());
    }

    @ApiOperation(value = "보낸 쪽지 확인", notes = "보낸 쪽지 확인")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/messages/sender/{messageId}")
    public Response sendMessageOne(@ApiParam(value = "메시지 ID",required = true) @PathVariable Long messageId){
        return Response.success(messageService.sendedMessage(messageId));
    }

    @ApiOperation(value = "보낸 쪽지 삭제", notes = "보낸 쪽지 삭제")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/messages/sender/{messageId}")
    public Response deleteSendedMessage(@ApiParam(value = "메시지 ID",required = true) @PathVariable Long messageId){
        messageService.deleteSendedMessage(messageId);
        return Response.success();
    }
}

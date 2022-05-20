package com.springboot.demo.web.controller;

import com.springboot.demo.domain.Member;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.security.TokenProvider;
import com.springboot.demo.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class MemberController {
    final private MemberService memberService;

    final private TokenProvider tokenProvider;

    @PostMapping("signup")
    public ResponseEntity<?> registerMember(@RequestBody MemberDto memberDto) {
        try {
            Member newMember = Member.builder()
                    .name(memberDto.getName())
                    .userId(memberDto.getUserId())
                    .password(memberDto.getPassword())
                    .build();

            System.out.println(newMember);
            Member registeredMember = memberService.create(newMember);
            System.out.println(registeredMember);

            MemberDto responseMemberDto = MemberDto.builder()
                    .name(registeredMember.getName())
                    .password(registeredMember.getPassword())
                    .userId(registeredMember.getUserId())
                    .build();

            return ResponseEntity.ok().body(responseMemberDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("signin")
    public ResponseEntity<?> authenticate(@RequestBody MemberDto memberDto) {
        Member member = memberService.find(memberDto.getUserId(), memberDto.getPassword());
        System.out.println(member);

        if(member != null){
            final String token = tokenProvider.create(member);
            final MemberDto responseMemberDto = MemberDto.builder()
                    .id(member.getId())
                    .name(memberDto.getName())
                    .userId(memberDto.getUserId())
                    .password(memberDto.getPassword())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseMemberDto);
        }else{
            return (ResponseEntity<?>) ResponseEntity.status(401);
        }
    }
}

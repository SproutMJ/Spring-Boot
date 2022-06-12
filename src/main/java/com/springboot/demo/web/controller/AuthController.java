package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.*;
import com.springboot.demo.service.auth.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.springboot.demo.domain.response.Response.success;

//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    final private MemberService memberService;
//
//    final private TokenProvider tokenProvider;
//
//    @PostMapping("signup")
//    public ResponseEntity<?> registerMember(@RequestBody MemberDto memberDto) {
//        try {
//            Member newMember = Member.builder()
//                    .name(memberDto.getName())
//                    .userId(memberDto.getUserId())
//                    .password(memberDto.getPassword())
//                    .build();
//
//            System.out.println(newMember);
//            Member registeredMember = memberService.create(newMember);
//            System.out.println(registeredMember);
//
//            MemberDto responseMemberDto = MemberDto.builder()
//                    .name(registeredMember.getName())
//                    .password(registeredMember.getPassword())
//                    .userId(registeredMember.getUserId())
//                    .build();
//
//            return ResponseEntity.ok().body(responseMemberDto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    @PostMapping("signin")
//    public ResponseEntity<?> authenticate(@RequestBody MemberDto memberDto) {
//        Member member = memberService.find(memberDto.getUserId(), memberDto.getPassword());
//        System.out.println(member);
//
//        if(member != null){
//            final String token = tokenProvider.create(member);
//            final MemberDto responseMemberDto = MemberDto.builder()
//                    .id(member.getId())
//                    .name(memberDto.getName())
//                    .userId(memberDto.getUserId())
//                    .password(memberDto.getPassword())
//                    .token(token)
//                    .build();
//            return ResponseEntity.ok().body(responseMemberDto);
//        }else{
//            return (ResponseEntity<?>) ResponseEntity.status(401);
//        }
//    }
//}

/**
 * @author  https://github.com/sosow0212
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
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value = "회원가입", notes = "회원가입 진행")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public Response register(@Valid @RequestBody RegisterDto registerDto) {
        authService.signup(registerDto);
        return success();
    }

    @ApiOperation(value = "로그인", notes = "로그인을 한다.")
    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public Response signIn(@Valid @RequestBody LoginRequestDto req) {
        return success(authService.signIn(req));
    }


    @ApiOperation(value = "토큰 재발급", notes = "토큰 재발급 요청")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

}


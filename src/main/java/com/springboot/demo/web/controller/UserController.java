package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    private final MemberService memberService;

    @ApiOperation(value = "전체 회원 조회", notes = "전체 회원 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users")
    public Response findAllUsers(){
        return Response.success(memberService.findAll());
    }

    @ApiOperation(value ="개별 회원 조회", notes = "개별 회원 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{id}")
    public Response findUsers(@ApiParam(value = "User ID", required = true) @PathVariable Long id){
        return Response.success(memberService.find(id));
    }

    @ApiOperation(value ="개별 회원 수정", notes = "개별 회원 수정")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/users/{id}")
    public Response updateUser(@ApiParam(value = "User ID", required = true) @PathVariable Long id, @RequestBody MemberDto updateMemberInfoDto){
        memberService.updateUser(id, updateMemberInfoDto);
        return Response.success();
    }

    @ApiOperation(value ="개별 회원 탈퇴", notes = "개별 회원 탈퇴")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/users/{id}")
    public Response deleteUser(@ApiParam(value = "User ID", required = true) @PathVariable Long id){
        memberService.deleteUser(id);
        return Response.success();
    }

    @ApiOperation(value ="개별 회원 즐겨찾기 조회", notes = "개별 회원 즐겨찾기 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{id}/favorites")
    public Response findUserFavorites(@ApiParam(value = "User ID", required = true) @PathVariable Long id){
        return Response.success(memberService.findUserFavorites(id));
    }


}

package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.RegisterDto;
import com.springboot.demo.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.springboot.demo.domain.response.Response.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @ApiOperation(value = "통계 페이지", notes = "통계 페이지")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response adminInfo() {
        return success(adminService.findInfo());
    }

    @ApiOperation(value = "가입 유저 관리", notes = "가입 유저 관리")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/analysis/users")
    public Response registeredUsers() {
        return success(adminService.findAllUsers());
    }

    @ApiOperation(value = "게시판 관리", notes = "게시판 관리")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/analysis/boards")
    public Response registeredBoards() {
        return success(adminService.findAllBoards());
    }

    @ApiOperation(value = "신고 유저 관리", notes = "신고 유저 관리")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reports/users")
    public Response reportedUsers() {
        return success(adminService.findAllReportedUsers());
    }

    @ApiOperation(value = "신고 게시글 확인", notes = "신고 게시글 확인")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reports/boards")
    public Response reportedBoards() {
        return success(adminService.findAllReportedBoards());
    }
}

package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.BoardDto;
import com.springboot.demo.dto.report.BoardReportDto;
import com.springboot.demo.dto.report.MemberReportDto;
import com.springboot.demo.service.AdminService;
import com.springboot.demo.service.ReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/reports")
@RestController
public class ReportController {
    private ReportService reportService;

    @ApiOperation(value = "게시물 신고", notes = "게시물 신고")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/boards")
    public Response reportBoard(@ApiParam(value = "게시글 신고", required = true) @RequestBody BoardReportDto boardReportDto){
        reportService.reportBoard(boardReportDto);
        return Response.success();
    }

    @ApiOperation(value = "유저 신고", notes = "유저 신고")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public Response reportUser(@ApiParam(value = "유저 신고", required = true) @RequestBody MemberReportDto memberReportDto){
        reportService.reportUser(memberReportDto);
        return Response.success();
    }

}

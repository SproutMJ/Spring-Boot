package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.service.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    @ApiOperation(value = "게시물 댓글 조회", notes = "param으로 게시물 댓글 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findCommentAtBoard(@ApiParam(value = "게시글 번호", required = true)@RequestParam(name = "boardId") Long boardId){
        return Response.success(commentService.findCommentsByBoardId(boardId));
    }

    @ApiOperation(value = "게시물 댓글 조회", notes = "게시물 댓글 조회")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response createCommentAtBoard(@ApiParam(value = "게시글 번호", required = true)@RequestParam(name = "boardId") Long boardId,
                                         @ApiParam(value = "댓글", required = true)@RequestParam(name = "comment") String comment){
        commentService.createCommentInBoard(boardId, comment);
        return Response.success();
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글 삭제")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{commentId}")
    public Response deleteComment(@ApiParam(value = "댓글 번호", required = true)@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return Response.success();
    }
}

package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.BoardDto;
import com.springboot.demo.service.BoardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BoardController {
    private final BoardService boardService;

    @ApiOperation(value = "전체 게시물 조회", notes = "전체 게시물 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards")
    public Response findAllBoards(){
        return Response.success(boardService.findAllBoards());
    }
    
    @ApiOperation(value = "게시물 작성", notes = "게시물 작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/boards")
    public Response createBoard(@ApiParam(value = "게시글", required = true) @RequestBody BoardDto boardDto){
        boardService.createBoard(boardDto);
        return Response.success();
    }
    
    @ApiOperation(value = "개별 게시물 조회", notes = "개별 게시물 조회")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards/{id}")
    public Response findBoard(@ApiParam(value = "글번호", required = true) @PathVariable Long id){
        return Response.success(boardService.findById(id));
    }
    
    @ApiOperation(value = "개별 게시물 수정", notes = "개별 게시물 수정")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/boards/{id}")
    public Response updateBoard(@ApiParam(value = "글번호", required = true) @PathVariable Long id
            , @ApiParam(value = "업데이트 게시글", required = true) @RequestBody BoardDto updateBoardDto){
        boardService.updateBoard(id, updateBoardDto);
        return Response.success();
    }
    
    @ApiOperation(value = "개별 게시물 삭제", notes = "개별 게시물 삭제")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/boards/{id}")
    public Response deleteBoard(@ApiParam(value = "글번호", required = true) @PathVariable Long id){
        boardService.deleteBoard(id);
        return Response.success();
    }
    
    @ApiOperation(value = "게시글 검색", notes = "게시글 검색")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards/search")
    public Response searchBoards(@ApiParam(value = "글제목", required = true) @RequestParam String title){
        return Response.success(boardService.findByTitle(title));
    }
    
    @ApiOperation(value = "좋아요 처리", notes = "좋아요 처리")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/boards/{id}")
    public Response like(@ApiParam(value = "글번호", required = true) @PathVariable Long id){
        boardService.likeBoard(id);
        return Response.success();
    }
    
    @ApiOperation(value = "즐겨찾기 처리", notes = "즐겨찾기 처리")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/boards/{id}/favorites")
    public Response favorite(@ApiParam(value = "글번호", required = true) @PathVariable Long id){
        boardService.favoriteBoard(id);
        return Response.success();
    }

}

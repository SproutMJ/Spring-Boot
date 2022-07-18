package com.springboot.demo.web.controller;

import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.CategoryDto;
import com.springboot.demo.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @ApiOperation(value = "카테고리 추가", notes = "카테고리 추가")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response createCategory(@ApiParam(value = " 부모 카테고리 ID", required = true)@RequestParam("parentId") Long parentId, @ApiParam(value = " 자식 카테고리", required = true)@RequestBody CategoryDto categoryDto){
        categoryService.createCategory(parentId, categoryDto);
        return Response.success();
    }
}

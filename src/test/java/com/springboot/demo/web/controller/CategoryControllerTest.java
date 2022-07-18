package com.springboot.demo.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.domain.category.Category;
import com.springboot.demo.dto.CategoryDto;
import com.springboot.demo.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService categoryService;

    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    void createCategory() throws Exception {
        Long parentId = 0L;
        CategoryDto categoryDto = CategoryDto.builder().title("test").parentCategory(null).build();

        mockMvc.perform(post("/api/categories")
                        .param("parentId", String.valueOf(parentId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(categoryDto)))
                .andExpect(status().isCreated());

        verify(categoryService).createCategory(refEq(parentId), refEq(categoryDto));
    }
}
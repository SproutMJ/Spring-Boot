package com.springboot.demo.service;

import com.springboot.demo.domain.category.Category;
import com.springboot.demo.domain.response.Response;
import com.springboot.demo.dto.CategoryDto;
import com.springboot.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(Long parentId, CategoryDto categoryDto) {

        Category parentCategory = null;
        if(parentId != 0L) parentCategory = categoryRepository.getById(parentId);
        categoryRepository.save(Category.builder().title(categoryDto.getTitle()).parentCategory(parentCategory).build());
    }
}

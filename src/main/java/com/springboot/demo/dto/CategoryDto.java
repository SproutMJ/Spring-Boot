package com.springboot.demo.dto;

import com.springboot.demo.domain.category.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String title;
    private Category parentCategory;
}

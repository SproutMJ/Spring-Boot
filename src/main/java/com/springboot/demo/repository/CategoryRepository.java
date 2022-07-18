package com.springboot.demo.repository;

import com.springboot.demo.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.leetcode.service;

import com.leetcode.domain.Category;
import com.leetcode.dto.CategoryCreateDTO;
import com.leetcode.mapper.CategoryMapper;
import com.leetcode.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public Category save(CategoryCreateDTO categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryRepository.save(category);
    }


}
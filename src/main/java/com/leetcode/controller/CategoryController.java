package com.leetcode.controller;

import com.leetcode.domain.Category;
import com.leetcode.dto.CategoryCreateDTO;
import com.leetcode.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryCreateDTO categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

}

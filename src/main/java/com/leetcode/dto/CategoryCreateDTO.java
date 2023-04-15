package com.leetcode.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryCreateDTO {
    @NotBlank(message = "Category name is not valid")
    private String name;
}

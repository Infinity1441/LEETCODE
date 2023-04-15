package com.leetcode.mapper;

import com.leetcode.domain.Category;
import com.leetcode.dto.CategoryCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    //@Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toEntity(CategoryCreateDTO categoryCreateDTO);
}

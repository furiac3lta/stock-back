package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.CategoryDto;
import com.marcedev.stock.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category entity);

    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryDto dto);
}

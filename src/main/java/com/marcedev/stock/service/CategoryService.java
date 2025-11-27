package com.marcedev.stock.service;

import com.marcedev.stock.dto.CategoryDto;
import com.marcedev.stock.entity.Category;
import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto create(CategoryDto dto);

    Category getById(Long id);
}

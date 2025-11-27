package com.marcedev.stock.service.impl;

import com.marcedev.stock.dto.CategoryDto;
import com.marcedev.stock.entity.Category;
import com.marcedev.stock.mapper.CategoryMapper;
import com.marcedev.stock.repository.CategoryRepository;
import com.marcedev.stock.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).toList();
    }

    @Override
    public CategoryDto create(CategoryDto dto) {
        Category entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }
}

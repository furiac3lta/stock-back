package com.marcedev.stock.controller;

import com.marcedev.stock.dto.CategoryDto;
import com.marcedev.stock.entity.Category;
import com.marcedev.stock.mapper.CategoryMapper;
import com.marcedev.stock.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<CategoryDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto dto) {
        return service.create(dto);
    }
}

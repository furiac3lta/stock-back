package com.marcedev.stock.service.impl;

import com.marcedev.stock.dto.ProductDto;
import com.marcedev.stock.entity.Category;
import com.marcedev.stock.entity.Product;
import com.marcedev.stock.mapper.ProductMapper;
import com.marcedev.stock.repository.CategoryRepository;
import com.marcedev.stock.repository.ProductRepository;
import com.marcedev.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ProductDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public ProductDto create(ProductDto dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Product product = mapper.toEntity(dto);
        product.setCategory(category);

        return mapper.toDto(repository.save(product));
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        mapper.updateFromDto(dto, product);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        product.setCategory(category);

        return mapper.toDto(repository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setActive(false);
        repository.save(product);
    }
}

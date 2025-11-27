package com.marcedev.stock.service;

import com.marcedev.stock.dto.ProductDto;
import com.marcedev.stock.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto create(ProductDto dto);

    ProductDto update(Long id, ProductDto dto);

    void delete(Long id);
}

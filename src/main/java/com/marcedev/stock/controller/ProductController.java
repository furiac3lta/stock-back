package com.marcedev.stock.controller;

import com.marcedev.stock.dto.ProductDto;
import com.marcedev.stock.entity.Product;
import com.marcedev.stock.mapper.ProductMapper;
import com.marcedev.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<ProductDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {

        // Validación: nombre no vacío
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre no puede estar vacío");
        }

        // Validación: stock inicial >= 0
        if (dto.getStock() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El stock inicial no puede ser negativo");
        }

        // Validación: precio costo >= 0
        if (dto.getCostPrice() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio de costo no puede ser negativo");
        }

        // Validación: precio venta >= 0
        if (dto.getSalePrice() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio de venta no puede ser negativo");
        }

        return service.create(dto);
    }


    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

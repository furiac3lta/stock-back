package com.marcedev.stock.controller;

import com.marcedev.stock.dto.BranchDto;
import com.marcedev.stock.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService service;

    @GetMapping
    public List<BranchDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BranchDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public BranchDto create(@RequestBody BranchDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public BranchDto update(@PathVariable Long id, @RequestBody BranchDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

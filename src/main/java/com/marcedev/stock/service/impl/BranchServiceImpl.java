package com.marcedev.stock.service.impl;

import com.marcedev.stock.dto.BranchDto;
import com.marcedev.stock.entity.Branch;
import com.marcedev.stock.mapper.BranchMapper;
import com.marcedev.stock.repository.BranchRepository;
import com.marcedev.stock.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchMapper mapper;

    @Override
    public List<BranchDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BranchDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }

    @Override
    public BranchDto create(BranchDto dto) {

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new RuntimeException("El nombre de la sucursal no puede estar vacío");
        }

        Branch entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public BranchDto update(Long id, BranchDto dto) {

        Branch entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        mapper.updateFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        Branch entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        entity.setActive(false);
        repository.save(entity);
    }
}

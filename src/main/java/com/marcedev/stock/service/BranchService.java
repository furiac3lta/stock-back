package com.marcedev.stock.service;

import com.marcedev.stock.dto.BranchDto;
import java.util.List;

public interface BranchService {

    List<BranchDto> findAll();

    BranchDto findById(Long id);

    BranchDto create(BranchDto dto);

    BranchDto update(Long id, BranchDto dto);

    void delete(Long id);
}

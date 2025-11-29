package com.marcedev.stock.service;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.dto.StockTransferRequest;

import java.util.List;

public interface StockMovementService {

    List<StockMovementDto> findAll();

    List<StockMovementDto> history(Long productId);

    List<StockMovementDto> historyByBranch(Long branchId);


    // 🔥 Nueva función:
    StockMovementDto transfer(StockTransferRequest req);

    StockMovementDto move(Long productId, Integer quantity, String type, String description, String user);
}

package com.marcedev.stock.service;

import com.marcedev.stock.dto.StockMovementDto;

import java.util.List;

public interface StockMovementService {

    List<StockMovementDto> findAll();

    List<StockMovementDto> history(Long productId);

    StockMovementDto move(Long productId, Integer quantity, String type, String description, String user);
}

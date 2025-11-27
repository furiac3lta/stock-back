package com.marcedev.stock.service.impl;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.entity.MovementType;
import com.marcedev.stock.entity.Product;
import com.marcedev.stock.entity.StockMovement;
import com.marcedev.stock.mapper.StockMovementMapper;
import com.marcedev.stock.repository.ProductRepository;
import com.marcedev.stock.repository.StockMovementRepository;
import com.marcedev.stock.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository movementRepo;
    private final ProductRepository productRepo;
    private final StockMovementMapper mapper;

    @Override
    public List<StockMovementDto> findAll() {
        return movementRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<StockMovementDto> history(Long productId) {
        return movementRepo.findByProductIdOrderByCreatedAtDesc(productId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public StockMovementDto move(Long productId, Integer quantity, String type, String description, String user) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        int previousStock = product.getStock();
        int newStock;

        MovementType movementType = MovementType.valueOf(type);

        if (movementType == MovementType.INCREASE) {
            newStock = previousStock + quantity;
        } else {
            newStock = previousStock - quantity;
        }

        product.setStock(newStock);
        productRepo.save(product);

        StockMovement movement = StockMovement.builder()
                .product(product)
                .quantity(quantity)
                .movementType(movementType)
                .description(description)
                .createdBy(user)
                .createdAt(LocalDateTime.now())
                .build();

        movementRepo.save(movement);

        StockMovementDto dto = mapper.toDto(movement);
        dto.setPreviousStock(previousStock);
        dto.setNewStock(newStock);

        return dto;
    }
}

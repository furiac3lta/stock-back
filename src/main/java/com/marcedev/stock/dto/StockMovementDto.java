package com.marcedev.stock.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StockMovementDto {
    private Long id;
    private Long productId;
    private Integer quantity;
    private String movementType;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private Integer previousStock;
    private Integer newStock;
}

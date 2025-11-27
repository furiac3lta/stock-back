package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.entity.StockMovement;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StockMovementMapper {

    @Mapping(source = "product.id", target = "productId")
    StockMovementDto toDto(StockMovement movement);
}

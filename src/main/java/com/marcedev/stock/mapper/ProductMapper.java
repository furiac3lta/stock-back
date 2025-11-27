package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.ProductDto;
import com.marcedev.stock.entity.Category;
import com.marcedev.stock.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product entity);

    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateFromDto(ProductDto dto, @MappingTarget Product entity);
}

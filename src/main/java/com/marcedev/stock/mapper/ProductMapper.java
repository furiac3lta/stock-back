package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.ProductDto;
import com.marcedev.stock.entity.Branch;
import com.marcedev.stock.entity.Category;
import com.marcedev.stock.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "branchName", source = "branch.name")
    ProductDto toDto(Product entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "active", ignore = true)
    Product toEntity(ProductDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "branch", ignore = true)
    void updateFromDto(ProductDto dto, @MappingTarget Product entity);
}

package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.BranchDto;
import com.marcedev.stock.entity.Branch;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchDto toDto(Branch entity);

    Branch toEntity(BranchDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(BranchDto dto, @MappingTarget Branch entity);
}

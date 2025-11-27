package com.marcedev.stock.mapper;

import com.marcedev.stock.dto.UserDto;
import com.marcedev.stock.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User entity);
}

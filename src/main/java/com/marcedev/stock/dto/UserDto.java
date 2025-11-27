package com.marcedev.stock.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private Boolean active;
}

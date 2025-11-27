package com.marcedev.stock.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthResponseDto {
    private String token;
    private String username;
    private List<String> roles;
}

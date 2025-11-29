package com.marcedev.stock.dto;

import lombok.Data;

@Data
public class BranchDto {
    private Long id;
    private String name;
    private String address;
    private boolean active;
}

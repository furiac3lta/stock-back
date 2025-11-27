package com.marcedev.stock.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String sku;
    private Integer stock;
    private Double costPrice;
    private Double salePrice;
    private Long categoryId;
    private Boolean active;
}

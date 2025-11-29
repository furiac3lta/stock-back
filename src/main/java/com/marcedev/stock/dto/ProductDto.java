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
    private String categoryName;

    private Long branchId;
    private String branchName;

    private Boolean active;
}

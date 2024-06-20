package com.ecommerce.domain.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {
    private Long categoryId;

    private String categoryName;

    private String description;
}

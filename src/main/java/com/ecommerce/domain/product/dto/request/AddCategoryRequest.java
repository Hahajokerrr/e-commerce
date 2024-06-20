package com.ecommerce.domain.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class AddCategoryRequest {
    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;
}

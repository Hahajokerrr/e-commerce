package com.ecommerce.domain.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditCategoryRequest {
    @NotBlank
    private Long CategoryId;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;
}

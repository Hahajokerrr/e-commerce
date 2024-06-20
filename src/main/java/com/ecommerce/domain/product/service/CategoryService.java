package com.ecommerce.domain.product.service;

import com.ecommerce.common.util.PageResponseDto;
import com.ecommerce.domain.product.dto.request.AddCategoryRequest;
import com.ecommerce.domain.product.dto.request.EditCategoryRequest;
import com.ecommerce.domain.product.dto.response.CategoryResponse;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CategoryService {
    PageResponseDto<CategoryResponse> findAllCategories(Pageable pageable);

    List<CategoryResponse> findAllCategoriesByNameOrDescription(String keyword);

    CategoryResponse findCategoryById(Long categoryId);

    CategoryResponse addCategory(AddCategoryRequest categoryRequest);

    CategoryResponse editCategory(EditCategoryRequest categoryRequest);


}

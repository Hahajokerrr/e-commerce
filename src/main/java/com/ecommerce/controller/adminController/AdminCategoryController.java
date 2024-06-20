package com.ecommerce.controller.adminController;

import com.ecommerce.domain.product.dto.request.AddCategoryRequest;
import com.ecommerce.domain.product.dto.request.EditCategoryRequest;
import com.ecommerce.domain.product.dto.response.CategoryResponse;
import com.ecommerce.domain.product.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/category")
public class AdminCategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@Valid @RequestBody AddCategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.addCategory(categoryRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> UpdateCategory(@Valid @RequestBody EditCategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.editCategory(categoryRequest), HttpStatus.CREATED);
    }
}
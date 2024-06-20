package com.ecommerce.controller.permitAll;

import com.ecommerce.common.util.PageResponseDto;
import com.ecommerce.domain.product.dto.response.CategoryResponse;
import com.ecommerce.domain.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CategoryResponse>> getAllCategories(Pageable pageable){
        return new ResponseEntity<>(categoryService.findAllCategories(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> getAllCategoriesByNameOrDescription(@RequestParam("query") String keyword){
        return new ResponseEntity<>(categoryService.findAllCategoriesByNameOrDescription(keyword), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long categoryId){
        return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK);
    }
}

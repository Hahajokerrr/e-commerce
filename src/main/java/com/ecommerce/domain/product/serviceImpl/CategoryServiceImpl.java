package com.ecommerce.domain.product.serviceImpl;

import com.ecommerce.common.util.PageResponseDto;
import com.ecommerce.domain.product.dto.request.AddCategoryRequest;
import com.ecommerce.domain.product.dto.request.EditCategoryRequest;
import com.ecommerce.domain.product.dto.response.CategoryResponse;
import com.ecommerce.domain.product.exception.ProductException;
import com.ecommerce.domain.product.model.Category;
import com.ecommerce.domain.product.repository.CategoryRepository;
import com.ecommerce.domain.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;


    @Override
    public PageResponseDto<CategoryResponse> findAllCategories(Pageable pageable) {
        Page<Category> page = categoryRepository.findAll(pageable);

        List<CategoryResponse> data = page
                .getContent().stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .toList();

        PageResponseDto<CategoryResponse> pageResponseDto = new PageResponseDto<>();
        pageResponseDto.setData(data);
        pageResponseDto.setTotalPage(page.getTotalPages());
        pageResponseDto.setSize(page.getSize());
        pageResponseDto.setPageNumber(page.getNumber());
        pageResponseDto.setSort(page.getSort().toString());

        return pageResponseDto;
    }

    @Override
    public List<CategoryResponse> findAllCategoriesByNameOrDescription(String keyword) {
        List<Category> categories = categoryRepository.findAllByCategoryNameContainingOrDescriptionContaining(keyword, keyword);

        if (categories.isEmpty()) {
            throw ProductException.notFound("No categories found matching the search criteria");
        } else {
            return categories.stream().map(category -> modelMapper.map(category, CategoryResponse.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public CategoryResponse findCategoryById(Long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        if (category == null) {
            throw ProductException.notFound("Could not found that category with the Id");
        } else {
            return modelMapper.map(category, CategoryResponse.class);
        }
    }

    @Override
    public CategoryResponse addCategory(AddCategoryRequest categoryRequest) {
        categoryRepository.save(modelMapper.map(categoryRequest, Category.class));
        return modelMapper.map(categoryRequest, CategoryResponse.class);
    }

    @Override
    public CategoryResponse editCategory(EditCategoryRequest categoryRequest) {
        Category category = categoryRepository.findByCategoryId(categoryRequest.getCategoryId());
        if(category != null) {
            categoryRepository.save(modelMapper.map(categoryRequest, Category.class));
        } else {
            throw ProductException.notFound("Could not found that category with the Id");
        }
        return modelMapper.map(category, CategoryResponse.class);
    }
}

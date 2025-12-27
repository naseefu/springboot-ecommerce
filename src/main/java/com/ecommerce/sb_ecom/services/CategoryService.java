package com.ecommerce.sb_ecom.services;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

// for modularity and to promote loose coupling
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
}

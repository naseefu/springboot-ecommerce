package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    // spring will scan for the bean of type CategoryService and inject
    private CategoryService categoriesService;

    // constructor injection is preferred over field injection
    public CategoryController(CategoryService categoriesService){
        this.categoriesService = categoriesService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoriesService.createCategory(category);
        return "Category added successfully";
    }

}

package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/api/admin/categories")
    public String createCategory(@RequestBody Category category){
        categoriesService.createCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try{
            String result = categoriesService.deleteCategory(categoryId);
            //return new ResponseEntity<>(result, HttpStatus.OK); -- most common one
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){

        try{
            Category updatedCategory = categoriesService.updateCategory(category, categoryId);
            return ResponseEntity.status(HttpStatus.OK).body("Category with category id : "+category.getCategoryId()+" has updated successfully.");
        }
        catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }

    }

}

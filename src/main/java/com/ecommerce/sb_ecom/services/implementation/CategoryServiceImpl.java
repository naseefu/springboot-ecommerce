package com.ecommerce.sb_ecom.services.implementation;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private Long uniqueIds = 0L;
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(++uniqueIds);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categories.stream().filter(cat-> cat.getCategoryId().equals(categoryId))
                .findFirst()
                //.orElse(null); // if the category not found for the id, category will be null
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        if(category!=null){
            categories.remove(category);
            return "Category with id : "+categoryId+" removed successfully";
        }
        return "Category not found for id : "+categoryId;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        return null;
    }

}

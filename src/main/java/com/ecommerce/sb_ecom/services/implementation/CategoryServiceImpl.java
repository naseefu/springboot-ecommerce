package com.ecommerce.sb_ecom.services.implementation;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .findFirst().orElse(null);

        if(category!=null){
            categories.remove(category);
            return "Category with id : "+categoryId+" removed successfully";
        }
        return "Category not found for id : "+categoryId;
    }

}

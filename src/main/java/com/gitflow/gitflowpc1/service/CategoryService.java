package com.gitflow.gitflowpc1.service;

import com.gitflow.gitflowpc1.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Long id);
}

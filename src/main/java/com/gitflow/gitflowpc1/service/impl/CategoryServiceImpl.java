package com.gitflow.gitflowpc1.service.impl;

import com.gitflow.gitflowpc1.dao.CategoryDao;
import com.gitflow.gitflowpc1.entity.Category;
import com.gitflow.gitflowpc1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findById(id).orElseThrow(()->new RuntimeException("Caregoria no encontrada"));
    }

    @Transactional
    @Override
    public Category createCategory(Category category) {
        return categoryDao.save(category);
    }

    @Transactional
    @Override
    public Category updateCategory(Long id,Category category) {
        Category oldCategory = categoryDao.findById(id).orElseThrow(()->new RuntimeException("Categoria no encontrada"));
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        return categoryDao.save(oldCategory);
    }

    @Transactional
    @Override
    public void deleteCategory(Long id) {
        categoryDao.deleteById(id);
    }
}

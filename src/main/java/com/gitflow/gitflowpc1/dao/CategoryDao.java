package com.gitflow.gitflowpc1.dao;

import com.gitflow.gitflowpc1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
}

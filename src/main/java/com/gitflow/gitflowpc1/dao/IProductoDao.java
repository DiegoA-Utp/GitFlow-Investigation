package com.gitflow.gitflowpc1.dao;

import com.gitflow.gitflowpc1.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto,Long> {
}

package com.gitflow.gitflowpc1.service;

import com.gitflow.gitflowpc1.entity.Producto;

import java.util.List;

public interface ProductoService {
    Producto getProductById(Long id);
    List<Producto> getAllProducts();
    Producto createProduct(Producto producto);
    Producto updateProduct(Long id, Producto producto);
    void deleteProduct(Long id);
}

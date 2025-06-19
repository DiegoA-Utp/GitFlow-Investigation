package com.gitflow.gitflowpc1.service.impl;

import com.gitflow.gitflowpc1.dao.IProductoDao;
import com.gitflow.gitflowpc1.entity.Category;
import com.gitflow.gitflowpc1.entity.Producto;
import com.gitflow.gitflowpc1.service.CategoryService;
import com.gitflow.gitflowpc1.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final IProductoDao productoDao;
    private final CategoryService categoryService;

    public ProductoServiceImpl(IProductoDao productoDao,CategoryService categoryService){
        this.productoDao=productoDao;
        this.categoryService=categoryService;
    }

    @Transactional(readOnly = true)
    @Override
    public Producto getProductById(Long id) {
        return productoDao.findById(id).orElseThrow(()->new RuntimeException("Producto no encontrado"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> getAllProducts() {
        return productoDao.findAll();
    }

    @Transactional
    @Override
    public Producto createProduct(Producto producto) {
        return productoDao.save(producto);
    }

    @Transactional
    @Override
    public Producto updateProduct(Long id, Producto producto) {
       Producto oldProducto = this.getProductById(id);
       oldProducto.setName(producto.getName());
       oldProducto.setDescription(producto.getDescription());
       oldProducto.setPrice(producto.getPrice());
        Category category= categoryService.getCategoryById(producto.getCategory().getId());
        oldProducto.setCategory(category);
        return productoDao.save(oldProducto);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productoDao.deleteById(id);
    }
}

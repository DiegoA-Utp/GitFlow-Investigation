package com.gitflow.gitflowpc1.controller;

import com.gitflow.gitflowpc1.entity.Producto;
import com.gitflow.gitflowpc1.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService=productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts(){
        return ResponseEntity.ok(productoService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Producto> createProduct(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.createProduct(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable Long id,@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.updateProduct(id,producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}

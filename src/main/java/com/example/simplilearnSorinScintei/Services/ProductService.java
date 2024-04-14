package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    List<Product> getProductsByCategory(String category);
    List<Product> addProduct(Product product) ;
    Product updateProduct(int id, Product product);
    List<Product> deleteProduct(int id);
}

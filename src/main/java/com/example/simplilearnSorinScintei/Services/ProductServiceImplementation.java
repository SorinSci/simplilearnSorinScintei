package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.Product;
import com.example.simplilearnSorinScintei.Repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService{

    private final ProductRepository productRepository;

    private   EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {

            Optional<Product> product  = productRepository.findById(id);
            return product.orElse(null);

    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        return productRepository.getByCategory(category);
    }

    @Override
    public List<Product> addProduct(Product product) {
            productRepository.save(product);
            return productRepository.findAll();
    }

    @Override
    public Product updateProduct(int id, Product product)  {
            Optional<Product> productToBeUpdated = productRepository.findById(id);
                productToBeUpdated.get().setName(product.getName());
                productToBeUpdated.get().setCategory(product.getCategory());
                productToBeUpdated.get().setPrice(product.getPrice());
                productToBeUpdated.get().setQuantity(product.getQuantity());
                productToBeUpdated.get().setCategory(product.getCategory());
           return productRepository.save(productToBeUpdated.get());
    }

    @Override
    public List<Product> deleteProduct(int id)  {
            Optional<Product> productToBeDeleted = productRepository.findById(id);
            productRepository.delete(productToBeDeleted.get());
            return productRepository.findAll();

    }
}


package com.example.simplilearnSorinScintei.Repositories;

import com.example.simplilearnSorinScintei.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> getByCategory(String category);
}

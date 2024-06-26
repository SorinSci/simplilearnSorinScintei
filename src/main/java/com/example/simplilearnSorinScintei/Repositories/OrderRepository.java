package com.example.simplilearnSorinScintei.Repositories;

import com.example.simplilearnSorinScintei.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
@Query("SELECT o FROM Order o JOIN o.product p WHERE p.category = :category")
List<Order> getOrdersByCategory(String category);

}

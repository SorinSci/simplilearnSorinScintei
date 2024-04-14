package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrders();
    Optional<Order> getOrderById(int id) ;
    List<Order> getOrdersByCategory(String category);
    List<Order> addOrder(int productId);
    Order updateOrder(int orderId, int productId);
    List<Order> deleteOrder(int id) ;
}

package com.example.simplilearnSorinScintei.Services;


import com.example.simplilearnSorinScintei.Models.Order;
import com.example.simplilearnSorinScintei.Models.Product;
import com.example.simplilearnSorinScintei.Repositories.OrderRepository;
import com.example.simplilearnSorinScintei.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final  OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id)  {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getOrdersByCategory(String category) {

        return orderRepository.getOrdersByCategory(category);
    }

    @Override
    public List<Order> addOrder(int productId) {
            Order order = new Order();
            order.setDateAndTime(LocalDateTime.now());
            Optional<Product> product = productRepository.findById(productId);
            product.ifPresent(order::setProduct);
            orderRepository.save(order);
            return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(int orderId, int productId) {
            Optional<Order> order = orderRepository.findById(orderId);
            Optional<Product> productNew = productRepository.findById(productId);
            order.get().setProduct(productNew.get());
            return orderRepository.findById(orderRepository.findAll().size()).get();
    }

    @Override
    public List<Order> deleteOrder(int id)  {

            Optional<Order> orderToBeDeleted = orderRepository.findById(id);
            orderRepository.delete(orderToBeDeleted.get());
            return orderRepository.findAll();

    }
}

package com.example.simplilearnSorinScintei.Controllers;

import com.example.simplilearnSorinScintei.Models.Order;
import com.example.simplilearnSorinScintei.Services.OrderService;
import com.example.simplilearnSorinScintei.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping("/getAll")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById")
    public Optional<Order> getOrderById(@RequestParam int id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/getByCategory")
    public List<Order> getOrderByCategory(@RequestParam String category) {
        return orderService.getOrdersByCategory(category);
    }

    @GetMapping("/getByDate")
    public String getOrdersByDate() {
        return "TO DO";
    }

    @PostMapping("/add")
    public String placeOrder(@RequestParam int productId, Model model ) {
        orderService.addOrder(productId);
        model.addAttribute("orders",orderService.getAllOrders());
        model.addAttribute("products",productService.getAllProducts());

        return "customerDashboard";
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestParam int orderId,
                             @RequestParam int productId) {
        return orderService.updateOrder(orderId, productId);
    }

    @DeleteMapping("/delete")
    public List<Order> deleteOrder(@RequestParam int id) {
        return orderService.deleteOrder(id);
    }
}

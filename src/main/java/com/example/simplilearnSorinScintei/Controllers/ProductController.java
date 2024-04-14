package com.example.simplilearnSorinScintei.Controllers;

import com.example.simplilearnSorinScintei.Models.Product;
import com.example.simplilearnSorinScintei.Services.OrderService;
import com.example.simplilearnSorinScintei.Services.ProductService;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final  ProductService productService;
    private final OrderService orderService;

    @GetMapping("/getAll")
    public String  getAllProducts(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders",orderService.getAllOrders());

        return "customerDashboard";
    }
    @GetMapping("/getAllAdminDashboard")
    public String  getAllAdmin(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders",orderService.getAllOrders());

        return "adminDashboard";
    }

    @GetMapping("/getById")
    public Product getProductById(@RequestParam int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getAllByCategory")
    public String getProductsByCategory(@RequestParam String categoryToShow, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(categoryToShow));
        model.addAttribute("orders", orderService.getAllOrders());
        return "adminDashboard";
    }

    @PostMapping("/add")
    public String  saveProduct(@RequestParam String productName,
                               @RequestParam double price,
                               @RequestParam int quantity,
                               @RequestParam String category,
                               Model model)  {
        Product product = new Product();
        product.setName(productName);
        product.setCategory(category);
        product.setPrice(price);
        product.setQuantity(quantity);
        productService.addProduct(product);
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        return "adminDashboard";}

    @PutMapping("/update")
    public Product updateProduct(@RequestParam int id, @RequestBody Product product)  {
        return productService.updateProduct(id, product);
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int productId,Model model) {
        productService.deleteProduct(productId);
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        return "adminDashboard";
    }
}

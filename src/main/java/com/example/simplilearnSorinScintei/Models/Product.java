package com.example.simplilearnSorinScintei.Models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "products")
@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Integer quantity;
}

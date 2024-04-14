package com.example.simplilearnSorinScintei.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name ="orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
    @Column(name = "Date_Time")
    private LocalDateTime dateAndTime;

}

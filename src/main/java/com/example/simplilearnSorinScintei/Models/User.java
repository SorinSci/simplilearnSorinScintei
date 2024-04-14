package com.example.simplilearnSorinScintei.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users ")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "enabled")
    private int enabled;
}

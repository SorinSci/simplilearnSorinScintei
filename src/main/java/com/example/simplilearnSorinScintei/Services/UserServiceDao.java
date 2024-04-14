package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceDao extends UserDetailsService {

    public User findByUsername(String fullName);
}

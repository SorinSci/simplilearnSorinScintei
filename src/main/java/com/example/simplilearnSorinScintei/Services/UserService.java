package com.example.simplilearnSorinScintei.Services;

import com.example.simplilearnSorinScintei.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id) ;
    List<User> addUser(User user);
    List<User> deleteUser(int id);
    User getUserByUserName(String username);
}

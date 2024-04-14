package com.example.simplilearnSorinScintei.Controllers;

import com.example.simplilearnSorinScintei.Models.User;
import com.example.simplilearnSorinScintei.Repositories.UserRepository;
import com.example.simplilearnSorinScintei.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/getAll")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("objectList", users);
        return "customer";
    }

    @GetMapping("/getByUsername")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUserName(username);
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam int id)  {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete")
    public List<User> deleteUser(@RequestParam int id) {
        return userService.deleteUser(id);
    }
}

package com.example.simplilearnSorinScintei.Controllers;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/home")
    public String showHomePage(){
        return "home";
    }

}

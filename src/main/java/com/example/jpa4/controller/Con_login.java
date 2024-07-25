package com.example.jpa4.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Con_login {

    @GetMapping("/login")
    public String dologIn( ) {
        return "/login/login";
    }
}

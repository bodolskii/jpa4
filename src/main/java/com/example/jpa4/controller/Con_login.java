package com.example.jpa4.controller;


import com.example.jpa4.entity.Study_member;
import com.example.jpa4.service.StudyMemberService;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class Con_login {

    private final   StudyMemberService studyMemberService;


    private final PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String login( ) {
        return "/login/login";
    }



}

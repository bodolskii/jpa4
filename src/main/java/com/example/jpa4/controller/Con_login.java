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

    @Autowired
    StudyMemberService studyMemberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PermitAll
    @GetMapping("/login")
    public String login( ) {
        return "/login/login";
    }

    @PermitAll
    @PostMapping("/login_exe")
    public String login_exe(String loginId, String password, Model model, HttpSession session) {
        log.info(loginId+"loginId ====================");
        Study_member studyMember = studyMemberService.findAllByLoginId(loginId);
        log.info(studyMember+"studyMember ====================");


//        String passcode = passwordEncoder.encode(password);
//        log.info(passcode+"passcode ====================" + studyMember.getPassword());


        if(passwordEncoder.matches(password, studyMember.getPassword())) {
            session.setAttribute("studyMember", studyMember);
            return "redirect:/study/list";
        }else {
            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/login/login";
        }

    }
}

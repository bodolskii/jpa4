package com.example.jpa4.controller;

import com.example.jpa4.entity.Study_member;
import com.example.jpa4.service.StudyMemberService;
import jakarta.annotation.security.PermitAll;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/member")
public class Con_member {


    @Autowired
    StudyMemberService studyMemberService;

    //전체멤버조회
    @GetMapping("/list")
    public String doMemberList(Model model)throws Exception {

        List<Study_member> list = studyMemberService.doSelectAll();
        model.addAttribute("list",list);
        return "/member/member_list";
    }

    //멤버추가
    @GetMapping("/insert")
    public String doIns() {
        return "/member/member_join";
    }
    //회원가입
    @PostMapping("/insert_exe")
    public String doInsert(@ModelAttribute Study_member study_member) {
        studyMemberService.doInsert(study_member);
        return "redirect:/member/list";
    }

    //회원삭제
    @GetMapping("/delete")
    public String doDeleteMember(@RequestParam(value = "memberId") String strMemberId) {
        studyMemberService.doDelete(Integer.parseInt(strMemberId));
        return "redirect:/member/list";
    }


}

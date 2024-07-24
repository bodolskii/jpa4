package com.example.jpa4.controller;

import com.example.jpa4.entity.Study_record;
import com.example.jpa4.service.StudyRecordService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/study")
public class Con_study {

    @Autowired
    StudyRecordService recordService;


    @GetMapping("/List")
    public String doStudyList(Model model) {
        List<Study_record> list = recordService.doSelectAll();

        model.addAttribute("list",list);
        return "/study/study_list";

    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/insert")
    public String doInsertStudy() {
        return "/study/study_insert";
    }

    @PostMapping("/insert_exe")
    public String doInsertStudy(@ModelAttribute Study_record record  ) {
        record.setReg_day(LocalDateTime.now());
        recordService.doInsert(record);
        return "redirect:/study/List";

    }

    @GetMapping("/modify")
    public String doModifyStudy(HttpServletRequest httpServletRequest, Model model) {
        Study_record study_record = recordService.doSelectOne(Integer.parseInt(httpServletRequest.getParameter("Id")));
        model.addAttribute("study_record",study_record);
        return "study/study_modify";

    }

    @PostMapping("/modify_exe")
    public String doModifyStudy(@ModelAttribute Study_record record) {
        record.setMod_day(LocalDateTime.now());
        recordService.doUpdate(record);
        return "redirect:/study/List";
    }
}

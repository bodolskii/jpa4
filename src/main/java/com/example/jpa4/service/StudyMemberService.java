package com.example.jpa4.service;


import com.example.jpa4.entity.Study_member;
import com.example.jpa4.entity.Study_record;
import com.example.jpa4.repository.StudyMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class StudyMemberService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    StudyMemberRepository studyMemberRepository;

    // 전체 Row Select
    public List<Study_member> doSelectAll() {
        return studyMemberRepository.findAll();
    }

    // One row Select
    public Study_member doSelectOne(int memberId) {
        return studyMemberRepository.findById(memberId).get();
    }

    // Insert
    public void doInsert(Study_member study_member) {
        String passEncoder = passwordEncoder.encode(study_member.getPassword());
        study_member.setPassword(passEncoder);

        studyMemberRepository.save(study_member);
    }
    //Update
    public void doUpdate(Study_member study_member) {
        studyMemberRepository.save(study_member);
    }

    //Delete
    public void doDelete(int id) {
        studyMemberRepository.deleteById(id);
    }

    //LogIn
    public Study_member findAllByLoginId(String loginId) {
        Study_member study_member = studyMemberRepository.findAllByLoginId(loginId);
        return study_member;
    }


}

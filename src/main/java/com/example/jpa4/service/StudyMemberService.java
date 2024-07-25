package com.example.jpa4.service;


import com.example.jpa4.entity.Study_member;
import com.example.jpa4.entity.Study_record;
import com.example.jpa4.repository.StudyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

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
}

package com.example.jpa4.service;


import com.example.jpa4.entity.Study_record;
import com.example.jpa4.repository.StudyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepository studyRecordRepo;

    // 전체 Row Select
    public List<Study_record> doSelectAll() {
        return studyRecordRepo.findAll();
    }

    // One row Select
    public Study_record doSelectOne(int id) {
        return studyRecordRepo.findById(id).get();
    }

    // Insert
    public void doInsert(Study_record study_record) {
        studyRecordRepo.save(study_record);
    }
    //Update
    public void doUpdate(Study_record study_record) {
        studyRecordRepo.save(study_record);
    }

    //Delete
    public void doDelete(int id) {
        studyRecordRepo.deleteById(id);
    }


}

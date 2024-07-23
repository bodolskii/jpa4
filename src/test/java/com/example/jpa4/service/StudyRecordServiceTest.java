package com.example.jpa4.service;

import com.example.jpa4.entity.Study_record;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService recordService;
    @Autowired
    private StudyRecordService studyRecordService;

    @Test
    void doSelectAll() {

    }

    @Test
    void doSelectOne() {
    }

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .STUDY_DAY("2024-07-23")
                .CONTENTS("test Insert")
                .reg_day(LocalDateTime.now())
                .build();

        recordService.doInsert(study_record);
    }

    @Test
    void doUpdate() {
//        recordService.doUpdate(
//                Study_record.builder()
//                        .id(3)
//                        .CONTENTS("Update Test")
//                        .build()
//        );
        //이건 다른 값을 초기화시켜버림

        Study_record record = studyRecordService.doSelectOne(3);
        record.setCONTENTS("upDate33");

        recordService.doUpdate(record);
    }

    @Test
    @Transactional
    //트랜젝션 롤백처리해줌 안지워짐
    void doDelete() {
        studyRecordService.doDelete(3);
    }
}
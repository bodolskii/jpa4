package com.example.jpa4.repository;

import com.example.jpa4.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecordRepository extends JpaRepository<Study_record,Integer> {


}

package com.example.jpa4.repository;

import com.example.jpa4.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudyMemberRepository extends JpaRepository<Study_member, Integer>{
}

package com.example.jpa4.repository;

import com.example.jpa4.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudyMemberRepository extends JpaRepository<Study_member, Integer>{
   Study_member findAllByLoginId(String loginId);
}

package com.example.jpa4.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Study_record {

    @jakarta.persistence.Id
    private Long id;

    private String STUDY_DAY;

    private String CONTENTS;

    private LocalDateTime reg_day;



}

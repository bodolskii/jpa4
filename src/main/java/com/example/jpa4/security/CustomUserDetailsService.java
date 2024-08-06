package com.example.jpa4.security;//package com.example.jpa4.security;
//
//
import com.example.jpa4.DTO.CustomUserDetails;
import com.example.jpa4.entity.Study_member;
import com.example.jpa4.repository.StudyMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

   private final StudyMemberRepository studyMemberRepository;




    @Override
    public UserDetails loadUserByUsername(String loginId)  throws UsernameNotFoundException {
        Study_member study_member = studyMemberRepository.findAllByLoginId(loginId);
        log.info(study_member+"커스텀유저디테일서비스");
        UserDetails userDetails = User.builder()
                .username(study_member.getLoginId())
                .roles(study_member.getRole())
                .password(study_member.getPassword())
                .build();
        return userDetails;
    }
}

package com.example.jpa4.security;//package com.example.jpa4.security;
//
//
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

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

   private final StudyMemberRepository studyMemberRepository;



    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
        Study_member study_member = studyMemberRepository.findAllByLoginId(username);

        if(study_member == null) {
            throw new UsernameNotFoundException(username + "을 찾을수 없습니다.");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(study_member.getName())
                .password(study_member.getPassword())
                .roles(study_member.getRole())
                .build();
    }
}

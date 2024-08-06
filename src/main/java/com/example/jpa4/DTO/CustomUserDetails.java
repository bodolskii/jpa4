package com.example.jpa4.DTO;

import com.example.jpa4.entity.Study_member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Study_member studyMember;


    public CustomUserDetails(Study_member study_member) {
        this.studyMember = study_member;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return studyMember.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return studyMember.getPassword();
    }

    @Override
    public String getUsername() {
        return studyMember.getLoginId();
    }
}

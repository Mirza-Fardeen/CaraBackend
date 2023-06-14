package com.example.cara.org.CaraSecurity.service;


import com.example.cara.org.CaraSecurity.domain.AppUser;
import com.example.cara.org.CaraSecurity.domain.AppUserRequest;
import com.example.cara.org.CaraSecurity.enumeration.Role;
import com.example.cara.org.CaraSecurity.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppService {
    @Autowired
    private AppUserRepo appUserRepo;

    public void registerUser(AppUserRequest appUserRequest){
        final AppUser build = AppUser.builder()
                .email(appUserRequest.getEmail())
                .password(appUserRequest.getPassword())
                .username(appUserRequest.getUsername())
                .profession(appUserRequest.getProfession())
                .joinDate(new Date())
                .role(Role.ROLE_USER.name())
                .authorities(Role.ROLE_USER.getAuthorities())
                .build();
        appUserRepo.save(build);
    }

    public AppUser getUserByName(String username){
        final AppUser byUsername = appUserRepo.findByUsername(username);
        return byUsername;
    }
}

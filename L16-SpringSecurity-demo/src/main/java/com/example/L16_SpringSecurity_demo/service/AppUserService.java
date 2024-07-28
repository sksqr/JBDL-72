package com.example.L16_SpringSecurity_demo.service;

import com.example.L16_SpringSecurity_demo.entity.AppUser;
import com.example.L16_SpringSecurity_demo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser createAppUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser = appUserRepo.save(appUser);
        return appUser;
    }

    public boolean changePassword(AppUser appUser, String newPassword){
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser = appUserRepo.save(appUser);
        return true;
    }
}

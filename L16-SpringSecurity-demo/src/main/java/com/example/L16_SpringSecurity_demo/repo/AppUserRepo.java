package com.example.L16_SpringSecurity_demo.repo;

import com.example.L16_SpringSecurity_demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
}

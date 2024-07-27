package com.example.L15_SpringSecurity_demo;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.builder()
                .username("rahul").password("$2a$10$wd1guhbA0XPdP/xXn6BY6uVjTU1.L47Oi29RlEDIxooFcqZQCJJiK")
                .roles("USER").build();
        UserDetails user2 = User.builder()
                .username("amit").password("$2a$10$NmTHp1lKltdXBanqPI6aV.Z7exBBCkeixGKsJ7J7Vw9TJYbfpaTI.")
                .roles("ADMIN").build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(user1);
        inMemoryUserDetailsManager.createUser(user2);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }


    //$2a$10$NmTHp1lKltdXBanqPI6aV.Z7exBBCkeixGKsJ7J7Vw9TJYbfpaTI.
    //$2a$10$lz0TAq9pv7GG2by/aFWPzuhiJjSjyjLK9YDvYH4kZsRH.cNcN0FB.
}

package com.example.L16_SpringSecurity_demo;

import com.example.L16_SpringSecurity_demo.entity.AppUser;
import com.example.L16_SpringSecurity_demo.repo.AppUserRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBBasedUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("No user with username:"+username);
        }
        return appUser;
    }
}

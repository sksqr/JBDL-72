package com.example.L16_SpringSecurity_demo.controller;


import com.example.L16_SpringSecurity_demo.entity.AppUser;
import com.example.L16_SpringSecurity_demo.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {



    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/hello")
    public String getHello(@AuthenticationPrincipal AppUser appUser){
        LOGGER.info("Processing hello request");
        //AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello "+appUser.getName()+ "! from Admin";
    }

    @PostMapping("/createUser")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser){
        appUser = appUserService.createAppUser(appUser);
        return ResponseEntity.ok(appUser);
    }


    @GetMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal AppUser appUser, @RequestParam String newPassword){
        appUserService.changePassword(appUser,newPassword);
        return ResponseEntity.ok("Password changed");
    }

}
//JSESSIONID=5D5326437487697440DFB2E414
//JSESSIONID=5D5326437487697440DFB2E4145C72BC
//JSESSIONID=5D5326437487697440DFB2E4145C72BC
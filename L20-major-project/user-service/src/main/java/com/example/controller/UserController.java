package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Long createUser(@RequestBody @Valid UserDto userDto) throws ExecutionException, InterruptedException {
        LOGGER.info("Processing UserCreation Request");
        return userService.createUser(userDto);
    }

}

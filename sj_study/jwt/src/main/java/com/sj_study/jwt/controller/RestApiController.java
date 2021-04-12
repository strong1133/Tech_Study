package com.sj_study.jwt.controller;

import com.sj_study.jwt.domain.User;
import com.sj_study.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("home")
    public String home(){
        return "<h1>home</h1>";
    }

    @GetMapping("/api/hello")
    public String hello(){
        return "안뇽안뇽";
    }

    @PostMapping("token")
    public String token(){
        return "<h1>home</h1>";
    }

    @PostMapping("/api/signup")
    public User crateUser(@RequestBody User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        return userRepository.save(user);
    }

    @GetMapping("/api/user")
    public List<User> getUser(){
        return userRepository.findAll();
    }

}

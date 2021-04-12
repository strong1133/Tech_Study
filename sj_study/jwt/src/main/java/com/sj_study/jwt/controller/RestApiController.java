package com.sj_study.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

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

}

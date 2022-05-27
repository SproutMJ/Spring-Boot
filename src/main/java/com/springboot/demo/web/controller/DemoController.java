package com.springboot.demo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("test")
    public ResponseEntity<?> test(Authentication authentication){
        System.out.println(authentication.getName());
        return ResponseEntity.ok().body("test allow");
    }
}

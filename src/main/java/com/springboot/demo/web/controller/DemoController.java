package com.springboot.demo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok().body(null);
    }
}

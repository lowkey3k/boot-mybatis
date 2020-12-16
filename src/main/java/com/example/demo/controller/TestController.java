package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @PostMapping("/json")
    public Map<String,String> json(@RequestBody Map<String,String> json){
        return json;
    }
}

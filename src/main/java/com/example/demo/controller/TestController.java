package com.example.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping
@Validated
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @PostMapping("/json")
    public Map<String,String> json(@RequestBody Map<String,String> json){
        return json;
    }

    @PostMapping("/validation")
    public Object vali(@Valid @RequestBody TestVO testVO, BindingResult result){
        return testVO;
    }
}

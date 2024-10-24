package com.xushimin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/index")
    public String index() {
        return "login success";
    }
}

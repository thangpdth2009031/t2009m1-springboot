package com.example.t2009m1spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloT2009M1 {
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello hehe";
    }
}

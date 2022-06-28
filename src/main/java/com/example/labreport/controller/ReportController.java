package com.example.labreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }



}

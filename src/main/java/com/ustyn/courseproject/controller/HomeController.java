package com.ustyn.courseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home/home-page";
    }

    @GetMapping("/about-us")
    public String aboutUs() {
        return "home/about-us-page";
    }

}

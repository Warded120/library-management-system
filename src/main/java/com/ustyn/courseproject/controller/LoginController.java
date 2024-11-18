package com.ustyn.courseproject.controller;

import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.entity.user.Role;
import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

    @GetMapping("/home")
    public String home() {
        return "home-page";
    }
}

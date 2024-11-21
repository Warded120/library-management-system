package com.ustyn.courseproject.controller;

import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied-page";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password-page";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam("username") String username,
                                 RedirectAttributes redirectAttributes) {

        User user = userService.findByUsername(username);

        if (user != null) {

            redirectAttributes.addFlashAttribute("password", user.getPassword().getPassword());

            return "redirect:/forgot-password?success";
        } else {
            return "redirect:/forgot-password?error";
        }

    }
}

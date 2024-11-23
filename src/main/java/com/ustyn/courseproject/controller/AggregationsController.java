package com.ustyn.courseproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aggregation")
public class AggregationsController {
    @GetMapping("/one")
    public String one() {
        return "one";
    }
}

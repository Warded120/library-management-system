package com.ustyn.courseproject;

import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.entity.user.Role;
import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class UstynCourseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UstynCourseProjectApplication.class, args);
    }

}


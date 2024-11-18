package com.ustyn.courseproject;

import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.entity.user.Role;
import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userService.existsByUsername("admin")) {
            userService.deleteByUsername("admin");
        }

        Key key = new Key("Test123");
        User adminUser = new User("admin", key, true, List.of(new Role("ADMIN")));
        userService.save(adminUser);

        System.out.println("Default admin user created.");
    }
}

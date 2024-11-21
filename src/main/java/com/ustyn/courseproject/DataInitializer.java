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
        if(!userService.existsByUsername("admin")) {
            Key key1 = new Key("Test123");
            User adminUser = new User("admin", key1, true, List.of(new Role("ROLE_ADMIN")));
            userService.save(adminUser);
        }

        if(!userService.existsByUsername("operator")) {
            Key key2 = new Key("Something");
            User operatorUser = new User("operator", key2, true, List.of(new Role("ROLE_OPERATOR")));
            userService.save(operatorUser);
        }

        if(!userService.existsByUsername("guest")) {
            Key key3 = new Key("BibaBoba");
            User guestUser = new User("guest", key3, true, List.of(new Role("ROLE_GUEST")));
            userService.save(guestUser);
        }
    }
}

package com.ustyn.courseproject.service;

import com.ustyn.courseproject.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    User save(User user);
    void deleteByUsername(String username);
}

package com.ustyn.courseproject.service;

import com.ustyn.courseproject.entity.user.User;

public interface UserService {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    User save(User user);
    void deleteByUsername(String username);
}

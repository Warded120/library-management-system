package com.ustyn.courseproject.service;
import com.ustyn.courseproject.entity.user.Key;
import com.ustyn.courseproject.entity.user.Role;
import com.ustyn.courseproject.entity.user.User;
import com.ustyn.courseproject.repository.RoleRepository;
import com.ustyn.courseproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    KeyService keyService;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           KeyService keyService,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.keyService = keyService;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User save(User user) {
        Key key = new Key(user.getPassword().getPassword());
        Key savedKey = keyService.save(key);
        user.setPassword(savedKey);

        Collection<Role> roles = user.getRoles();
        Collection<Role> savedRoles = roleRepository.saveAll(roles);
        user.setRoles(savedRoles);

        // Save the User
        return userRepository.save(user);
    }

    @Override
    public void deleteByUsername(String username) {

        User user = userRepository.findByUsername(username);

        roleRepository.deleteAllById(user.getRoles().stream().map(Role::getId).toList());
        keyService.delete(user.getPassword());
        userRepository.delete(user);
    }
}

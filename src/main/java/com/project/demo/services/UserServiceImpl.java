package com.project.demo.services;

import com.project.demo.models.UserAccount;
import com.project.demo.repositories.RoleRepository;
import com.project.demo.repositories.UserAccountRepository;
import com.project.demo.services.interfaces.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private UserAccountRepository userRepo;
    private RoleRepository roleRepo;
    private BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserAccountRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @Override
    public void save(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userRepo.save(user);
    }

    @Override
    public UserAccount findByUsername(String name) {
        return userRepo.findByUsername(name);
    }
}

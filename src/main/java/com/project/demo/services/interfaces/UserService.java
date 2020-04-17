package com.project.demo.services.interfaces;

import com.project.demo.models.UserAccount;

public interface UserService {

    void save(UserAccount user);

    UserAccount findByUsername(String username);
}

package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.login.User;
import com.code.furamacasestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}

package com.code.blog.service.impl;

import com.code.blog.model.UserLogin;
import com.code.blog.repository.UserRepository;
import com.code.blog.service.UserLoginSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginSService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(UserLogin userLogin) {
        userRepository.save(userLogin);

    }
}

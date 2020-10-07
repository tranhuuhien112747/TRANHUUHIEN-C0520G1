package com.code.login.service.impl;

import com.code.login.model.UserLogin;
import com.code.login.repository.UserLoginRepository;
import com.code.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public void save(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
    }
}

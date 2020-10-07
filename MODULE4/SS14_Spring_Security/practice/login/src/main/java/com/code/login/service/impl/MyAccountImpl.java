package com.code.login.service.impl;

import com.code.login.model.MyAccount;
import com.code.login.model.UserLogin;
import com.code.login.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAccountImpl implements UserDetailsService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginRepository.findByName(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException("Account not found: " + username);
        }
        System.out.println(userLogin);
        return new MyAccount(userLogin);
    }
}

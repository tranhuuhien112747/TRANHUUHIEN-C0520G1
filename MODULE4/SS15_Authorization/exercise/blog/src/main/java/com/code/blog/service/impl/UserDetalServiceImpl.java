package com.code.blog.service.impl;

import com.code.blog.model.MyAccount;
import com.code.blog.model.UserLogin;
import com.code.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetalServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userRepository.findByName(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException("Account Not Found");
        }
        return new MyAccount(userLogin);
    }
}

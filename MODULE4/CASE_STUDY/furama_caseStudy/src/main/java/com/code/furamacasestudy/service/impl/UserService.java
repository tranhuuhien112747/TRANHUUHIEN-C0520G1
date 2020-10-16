package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.login.User;

public interface UserService {
    User findByUserName(String Username);
}

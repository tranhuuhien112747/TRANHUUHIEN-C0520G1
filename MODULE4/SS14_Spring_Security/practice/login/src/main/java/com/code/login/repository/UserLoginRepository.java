package com.code.login.repository;

import com.code.login.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByName(String name);
}

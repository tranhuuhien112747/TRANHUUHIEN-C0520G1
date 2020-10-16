package com.code.furamacasestudy.repository;

import com.code.furamacasestudy.model.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String name);
}

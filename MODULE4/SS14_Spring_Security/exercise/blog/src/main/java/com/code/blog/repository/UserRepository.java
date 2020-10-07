package com.code.blog.repository;

import com.code.blog.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin,Long> {
    UserLogin findByName(String userName);

}

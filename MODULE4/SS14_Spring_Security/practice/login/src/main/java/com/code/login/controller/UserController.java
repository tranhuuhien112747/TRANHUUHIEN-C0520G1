package com.code.login.controller;

import com.code.login.model.UserLogin;
import com.code.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserLoginService userLoginService;

    @GetMapping({"", "/hom"})
    public String getHome() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("761311");
        String password1 = bCryptPasswordEncoder.encode("112747");
        userLoginService.save(new UserLogin("c0520g1", password, "user", true));
        userLoginService.save(new UserLogin("anhhienpl.com", password1, "user", true));
        return "home";

    }

    @GetMapping("/hello")
    public String getHelloPage() {
        return "hello";
    }
}

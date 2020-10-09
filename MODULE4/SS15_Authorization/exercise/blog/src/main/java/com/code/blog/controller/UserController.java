//package com.code.blog.controller;
//
//import com.code.blog.model.UserLogin;
//import com.code.blog.service.UserLoginSService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserController {
//    @Autowired
//    UserLoginSService userLoginSService;
//
//    @GetMapping
//    public String getHome() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("123");
//        userLoginSService.save(new UserLogin("hien", password, "USER", true));
//        return "/blog/list";
//    }
//}

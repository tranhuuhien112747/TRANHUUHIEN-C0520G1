package com.code.furamacasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"", "/home"})
public class HomeController {
    @GetMapping
    public String getHome() {
        return "home/home";
    }

    @RequestMapping(value = "/error-403", method = RequestMethod.GET)
    public String getError() {
        return "home/error-403";
    }

    @RequestMapping(value = "/error-403", method = RequestMethod.POST)
    public String postError() {
        return "home/error-403";
    }
}

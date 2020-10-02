package com.code.count.controller;

import com.code.count.moldel.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myCounter")
public class CounterController {
    @ModelAttribute("myCounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "views";
    }
}

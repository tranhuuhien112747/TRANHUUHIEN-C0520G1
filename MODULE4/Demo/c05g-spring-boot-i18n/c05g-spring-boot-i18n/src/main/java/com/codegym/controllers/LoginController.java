package com.codegym.controllers;

import com.codegym.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("userInfo")
public class LoginController {

//    @ModelAttribute("userInfo")
//    public User initUser() {
//        return new User();
//    }

    @GetMapping("/login")
    public String login(Model model,
                        @CookieValue(value = "cookieUser", defaultValue = "") String usernameCookie,
                        @CookieValue(value = "cookiePassword", defaultValue = "") String passwordCookie) {
        model.addAttribute("userInfo", new User(usernameCookie, passwordCookie));
        model.addAttribute("userC", usernameCookie);
        model.addAttribute("passwordC", passwordCookie);
        return "login";
    }

    @PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute("userInfo") User user,
                             HttpServletResponse response,
                             HttpServletRequest request) {
        // set session
//        request.getSession().setAttribute("userInfo", user);
        // get session
//        User userServlet = (User) request.getSession().getAttribute("userInfo");

        // check login
        Cookie cookieUser = new Cookie("cookieUser", user.getUsername());
//        cookieUser.setMaxAge(10);
        Cookie cookiePassword = new Cookie("cookiePassword", user.getPassword());
//        cookiePassword.setMaxAge(10);

        response.addCookie(cookieUser);
        response.addCookie(cookiePassword);

        return "redirect:/list";
    }
}

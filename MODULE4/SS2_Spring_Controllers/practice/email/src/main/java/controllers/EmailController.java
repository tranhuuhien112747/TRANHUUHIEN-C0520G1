package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private Pattern pattern;
    private Matcher matcher;
    private final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping(value = {"", "/email"})
    public String getEmail() {
        return "checkMail";
    }

    private boolean validate(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @PostMapping
    public ModelAndView validateEmail(@RequestParam("email") String email) {
        ModelAndView modelAndView = new ModelAndView("checkMail");
        boolean isValid = validate(email);
        if (!isValid) {
            modelAndView.addObject("message", "Email is invalid");
        } else {
            modelAndView.addObject("email", email);
            modelAndView.addObject("message", "Hi!! " +email);
        }
        return modelAndView;
    }
}

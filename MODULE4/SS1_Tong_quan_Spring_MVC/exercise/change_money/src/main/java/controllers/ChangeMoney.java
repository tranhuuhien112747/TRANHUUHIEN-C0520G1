package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ChangeMoney {
    @GetMapping(value = {"","/usd"})
    public String getChangeMoney() {
        return "money";
    }

    @PostMapping(value = "/usd")
    public ModelAndView display(HttpServletRequest request) throws IOException {
        double usd = Double.parseDouble(request.getParameter("usd"));
        double vnd = usd * 25000;
        ModelAndView modelAndView = new ModelAndView("money");
        modelAndView.addObject("usd",usd);
        modelAndView.addObject("vnd",vnd);
        return modelAndView;
    }
}

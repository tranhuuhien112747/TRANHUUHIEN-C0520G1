package controllers;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"", "/calculator"})
public class CalculatorController {
    @GetMapping
    public String getCalculator() {
        return "calculator";
    }

    @PostMapping
    public ModelAndView getResultPage(@RequestParam double number1, double number2, String operator) {
        ModelAndView modelAndView = new ModelAndView("calculator");
        double result = Calculator.calculate(number1,number2,operator);
        modelAndView.addObject("num1",number1);
        modelAndView.addObject("num2",number2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}

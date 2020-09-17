package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String getHelloPage(){
        return "hello";
    }

    @GetMapping(value = "/hello1")
    public String getHelloPage1(Model model){
        model.addAttribute("name","Hai");
        return "hello";
    }

    @GetMapping(value = "/hello2")
    public String getHelloPage2(ModelMap modelMap){
        modelMap.addAttribute("name","Hai");
        modelMap.addAttribute("age","18");
        return "hello";
    }

    @GetMapping(value = "/hello3")
    public ModelAndView getHelloPage3(){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("name", "Hai");
        modelAndView.addObject("age", "20");
        return modelAndView;
    }


    @GetMapping(value = "/hello4")
    public ModelAndView getHelloPage4(){
        return new ModelAndView("hello","student",new Student("Hai",90));
    }
}

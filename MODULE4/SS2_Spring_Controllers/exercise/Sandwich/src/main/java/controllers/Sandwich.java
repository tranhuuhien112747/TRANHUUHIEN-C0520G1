package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"", "/sandwich"})
public class Sandwich {
    @GetMapping
    public String getSave() {
        return "dishplay";
    }

    @PostMapping
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("dishplay");
        if (condiment != null) {
            modelAndView.addObject("condiment1", condiment);
        } else {
            modelAndView.addObject("mess", "NOt");
        }
        return modelAndView;
    }

}

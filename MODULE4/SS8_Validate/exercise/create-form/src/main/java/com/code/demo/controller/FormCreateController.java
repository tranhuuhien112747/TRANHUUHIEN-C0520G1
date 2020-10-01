package com.code.demo.controller;

import com.code.demo.model.FormCreate;
import com.code.demo.service.FormCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"", "/form"})
public class FormCreateController {
    @Autowired
    FormCreateService formCreateService;

    @GetMapping
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("list",formCreateService.findAll());
        return modelAndView;
    }

    @GetMapping("/form/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("form", new FormCreate());
        return modelAndView;
    }

    @PostMapping("form/save")
    public ModelAndView save(@Validated @ModelAttribute("form") FormCreate formCreate, BindingResult bindingResult
    ) {
        new FormCreate().validate(formCreate, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/form");
            formCreateService.save(formCreate);
            modelAndView.addObject("form", formCreate);
            return modelAndView;

        }
    }
}

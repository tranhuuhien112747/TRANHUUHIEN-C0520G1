package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"", "/customer"})
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public ModelAndView showCustomer() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }


    @PostMapping("/customer/save")
    public ModelAndView save(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        modelAndView.addObject("success", "Save Customer Success!!!");
        return modelAndView;
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/customer/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.update(customer.getId(), customer);
        return modelAndView;
    }


    @GetMapping("/customer/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/customer/delete")
    public ModelAndView moveCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(customer.getId());
        return modelAndView;
    }
}

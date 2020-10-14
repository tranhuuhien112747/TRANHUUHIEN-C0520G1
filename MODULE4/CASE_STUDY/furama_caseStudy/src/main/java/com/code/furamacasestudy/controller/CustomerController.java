package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.model.CustomerType;
import com.code.furamacasestudy.service.CustomerService;
import com.code.furamacasestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("typeCustomer")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAllCustomerType();
    }


    @GetMapping
    public ModelAndView getCustomerPage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerList", customerService.finAllCustomer(pageable));
        return modelAndView;
    }

//    @GetMapping("/create")
//    public ModelAndView createCustomer() {
//        ModelAndView modelAndView = new ModelAndView("/customer/customer-create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Validated({Customer.CheckId.class,Customer.CheckEdit.class}) @ModelAttribute("customer") Customer customer, BindingResult bindingResult,@PageableDefault(value = 5) Pageable pageable) {
//        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
            modelAndView.addObject("customerList", customerService.finAllCustomer(pageable));
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            customerService.save(customer);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/customer/customer-edit");
        modelAndView.addObject("customer", customerService.finById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeCustomer(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(id);
        return modelAndView;
    }

}

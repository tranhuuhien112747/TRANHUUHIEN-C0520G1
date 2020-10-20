package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.model.CustomerType;
import com.code.furamacasestudy.service.CustomerService;
import com.code.furamacasestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
    public ModelAndView getCustomerPage(@PageableDefault(value = 5)
                                        @SortDefault(sort = {"customerName","customerId"}, direction = Sort.Direction.ASC) Pageable pageable,
                                        @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch,
                                        @RequestParam(value = "choose", defaultValue = "-1") int choose) {
//        ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
//        Page<Customer> customerList;
//        if ("".equals(inputSearch)) {
//            customerList = customerService.finAllCustomer(pageable);
//        } else {
//            customerList = customerService.findByIdAndName(inputSearch, pageable);
//        }
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("customerList", customerList);
//        modelAndView.addObject("inputSearch", inputSearch);
//        return modelAndView;
        ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
        Page<Customer> customerList = null;
        if ("".equals(inputSearch)) {
            customerList = customerService.findAllByStatusTrue(pageable);
        } else {
            switch (choose) {
                case 1:
                    customerList = customerService.findCustomerByCustomerBirthdayContaining(inputSearch, pageable);
                    break;
                case 2:
                    customerList = customerService.findCustomerByCustomerTypeContaining(inputSearch, pageable);
                    break;
                case 3:
                    customerList = customerService.findByIdAndName(inputSearch, pageable);
                    break;
                default:
                    break;
            }
        }
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customer2", new Customer());
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("inputSearch", inputSearch);
        modelAndView.addObject("choose", choose);
        return modelAndView;
    }

//    @GetMapping("/create")
//    public ModelAndView createCustomer() {
//        ModelAndView modelAndView = new ModelAndView("/customer/customer-create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Validated({Customer.CheckId.class, Customer.CheckEdit.class}) @ModelAttribute("customer") Customer customer,
                                     BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable,RedirectAttributes redirectAttributes) {
//        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
            modelAndView.addObject("customerList", customerService.findAllByStatusTrue(pageable));
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            customerService.save(customer);
            modelAndView.addObject("customer2", customer);
            redirectAttributes.addFlashAttribute("message","CreateSUCCSEADS!!1");
            return modelAndView;
        }

    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView editCustomer(@PathVariable String id) {
//        ModelAndView modelAndView = new ModelAndView("/customer/customer-edit");
//        modelAndView.addObject("customer", customerService.finById(id));
//        return modelAndView;
//    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@Validated(Customer.CheckEdit.class)@ModelAttribute("customer2") Customer customer,
                                       BindingResult bindingResult , Pageable pageable, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/customer/customer-list");
            modelAndView.addObject("customerList", customerService.findAllByStatusTrue(pageable));
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message","UpDateSuccess");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeCustomer(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(id);
        return modelAndView;
    }

    @GetMapping("/deleteSelect")
    public ModelAndView deleteSelect(@RequestParam String[] select) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        for (String string : select) {
          customerService.remove(string);
        }
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetail(@PathVariable String id ){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        modelAndView.addObject("customer",customerService.finById(id));
        return modelAndView;
    }

}

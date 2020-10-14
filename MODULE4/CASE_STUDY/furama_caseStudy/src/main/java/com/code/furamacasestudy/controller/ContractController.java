package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.*;
import com.code.furamacasestudy.service.ContractService;
import com.code.furamacasestudy.service.CustomerService;
import com.code.furamacasestudy.service.EmployeeService;
import com.code.furamacasestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("employeeList")
    public List<Employee> employeeList(){
        return employeeService.finAllEmployee();
    }

    @ModelAttribute("customerList")
    public List<Customer> customerList(){
        return customerService.finAllCustomer();
    }

    @ModelAttribute("serviceList")
    public List<Service> serviceList(){
        return serviceService.finAllService();
    }

    @GetMapping
    public ModelAndView getContractPage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract/contract-list");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("contractList",contractService.finAllContract(pageable));
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveContract(@ModelAttribute("contract") Contract contract) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        contractService.save(contract);
        modelAndView.addObject("contract", contract);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeContract(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        contractService.remove(id);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editContract(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/contract/contract-edit");
        modelAndView.addObject("contract",contractService.finById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateContract(@ModelAttribute("contract") Contract contract) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contract");
        contractService.save(contract);
        return modelAndView;
    }

}

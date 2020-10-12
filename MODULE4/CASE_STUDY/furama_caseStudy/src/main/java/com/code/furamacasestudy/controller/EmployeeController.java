package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.model.Employee;
import com.code.furamacasestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ModelAndView getEmployeePage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-list");
        modelAndView.addObject("customer", employeeService.finAllEmployee(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
}

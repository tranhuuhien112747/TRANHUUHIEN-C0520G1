package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.*;
import com.code.furamacasestudy.service.DivisionService;
import com.code.furamacasestudy.service.EducationService;
import com.code.furamacasestudy.service.EmployeeService;
import com.code.furamacasestudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;

    @ModelAttribute("educationList")
    public List<Education> getEducationList(){
        return educationService.findAllEducation();
    }
    @ModelAttribute("positionList")
    public List<Position> getPosition(){
        return positionService.findAllPosition();
    }
    @ModelAttribute("divisionList")
    public List<Division> getDivision(){
        return divisionService.findAllDivision();
    }

    @GetMapping
    public ModelAndView getEmployeePage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-list");
        modelAndView.addObject("employeeList", employeeService.finAllEmployee(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        employeeService.save(employee);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView removeEmployee(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        employeeService.remove(id);
        return modelAndView;
    }
}

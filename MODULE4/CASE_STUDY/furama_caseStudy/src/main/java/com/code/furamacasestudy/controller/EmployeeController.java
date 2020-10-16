package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.*;
import com.code.furamacasestudy.service.DivisionService;
import com.code.furamacasestudy.service.EducationService;
import com.code.furamacasestudy.service.EmployeeService;
import com.code.furamacasestudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public List<Education> getEducationList() {
        return educationService.findAllEducation();
    }

    @ModelAttribute("positionList")
    public List<Position> getPosition() {
        return positionService.findAllPosition();
    }

    @ModelAttribute("divisionList")
    public List<Division> getDivision() {
        return divisionService.findAllDivision();
    }

    @GetMapping
    public ModelAndView getEmployeePage(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-list");
        Page<Employee> employeeList;
        if ("".equals(inputSearch)) {
            employeeList = employeeService.finAllEmployee(pageable);
        } else {
            employeeList = employeeService.finByNameAndIdEmployee(inputSearch, pageable);
        }
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.addObject("inputSearch", inputSearch);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Validated({Employee.CheckID.class, Employee.EditCheck.class}) @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/employee-create");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            employeeService.save(employee);
            modelAndView.addObject("employee", employee);
            redirectAttributes.addFlashAttribute("message", "Create Success!!!");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeEmployee(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee");
        employeeService.remove(id);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee-edit");
        modelAndView.addObject("employee", employeeService.finById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@Validated(Employee.EditCheck.class) @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/employee-edit");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            employeeService.save(employee);
            modelAndView.addObject("employee", employee);
            redirectAttributes.addFlashAttribute("message","Update Success!!!!(@_@)");
            return modelAndView;
        }
    }
}

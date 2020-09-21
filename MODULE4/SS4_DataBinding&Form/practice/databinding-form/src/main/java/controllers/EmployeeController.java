package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee/")
public class EmployeeController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "addNew", method = RequestMethod.POST)
    public String addNewEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, ModelMap modelMap) {
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("id", employee.getId());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        return "employee/info";
    }
}

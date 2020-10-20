package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.*;
import com.code.furamacasestudy.service.RentTypeService;
import com.code.furamacasestudy.service.ServiceService;
import com.code.furamacasestudy.service.ServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceTypeService typeService;

    @ModelAttribute("rentTypeService")
    public List<RentType> rentTypeList() {
        return rentTypeService.findAllRentTypeService();
    }

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return typeService.findAllServiceType();
    }

    @GetMapping
    public ModelAndView getServicePage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/service/service-list");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("serviceList", serviceService.finAllService(pageable));
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveService(@Validated @ModelAttribute("service") Service service, BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable) {
//       new Service().validate(service,bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/service/service-list");
            modelAndView.addObject("serviceList", serviceService.finAllService(pageable));
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/service");
            serviceService.save(service);
            modelAndView.addObject("service", service);
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeService(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        serviceService.remove(id);
        return modelAndView;
    }

    @GetMapping("/deleteSelect")
    public ModelAndView delete(@RequestParam String[] select) {
        ModelAndView modelAndView = new ModelAndView("redirect:/service");
        if (select == null) {
            return modelAndView;
        } else {
            for (int i = 0; i < select.length; i++) {
                serviceService.remove(select[i]);
            }
        }

        return modelAndView;
    }

}

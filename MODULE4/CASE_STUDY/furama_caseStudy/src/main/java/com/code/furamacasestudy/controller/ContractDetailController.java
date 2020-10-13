package com.code.furamacasestudy.controller;

import com.code.furamacasestudy.model.*;
import com.code.furamacasestudy.service.AttachServiceSv;
import com.code.furamacasestudy.service.ContractDetailService;
import com.code.furamacasestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private AttachServiceSv attachServiceSv;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private ContractService contractService;


    @ModelAttribute("attachList")
    public List<AttachService> attachServiceList(){
        return attachServiceSv.findAllAttachService();
    }

    @ModelAttribute("contractList")
    public List<Contract> contractList(){
        return contractService.finAllContract();
    }


    @GetMapping
    public ModelAndView getContractDetailPage(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contractDetail/contractDetail-list");
        modelAndView.addObject("contractDetail",new ContractDetail());
        modelAndView.addObject("contractDetailList",contractDetailService.finAllService(pageable));
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        ModelAndView modelAndView = new ModelAndView("redirect:/contractDetail");
        contractDetailService.save(contractDetail);
        modelAndView.addObject("contractDetail", contractDetail);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView removeContractDetail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/contractDetail");
        contractDetailService.remove(id);
        return modelAndView;
    }
}

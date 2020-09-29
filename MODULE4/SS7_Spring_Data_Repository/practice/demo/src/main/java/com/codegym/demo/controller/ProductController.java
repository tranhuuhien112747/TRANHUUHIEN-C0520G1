package com.codegym.demo.controller;

import com.codegym.demo.model.ProductManager;
import com.codegym.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Component
@Controller
@RequestMapping({"", "/product"})
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public String getStudentPage(Model model, @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("list", productService.findAll(pageable));
        return "list";
    }

//    @GetMapping
//    public ModelAndView show() {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        List<ProductManager> productManagers = productService.findAll();
//        modelAndView.addObject("list", productManagers);
//        return modelAndView;

    @GetMapping("/product/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new ProductManager());
        return modelAndView;
    }

    @PostMapping("/product/save")
    public ModelAndView save(@ModelAttribute("product") ProductManager product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.save(product);
        return modelAndView;
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/update")
    public ModelAndView update(@ModelAttribute("product") ProductManager product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.update(product.getId(), product);
        return modelAndView;
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/product/delete")
    public ModelAndView remove(@ModelAttribute("product") ProductManager product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.remove(product.getId());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam String inputSearch,@PageableDefault(value = 3)Pageable pageable){
        return new ModelAndView("list", "list", productService.findByName(inputSearch,pageable));
    }
}

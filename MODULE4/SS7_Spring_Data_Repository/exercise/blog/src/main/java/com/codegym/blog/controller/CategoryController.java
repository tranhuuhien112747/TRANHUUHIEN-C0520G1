package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView listCategory(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("listCategory", categoryService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        categoryService.save(category);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editCategory(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        categoryService.update(category.getId(), category);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView remove(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        categoryService.remove(category.getId());
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/{id}/views")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);

        Iterable<Blog> blog = blogService.findAll();

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

}

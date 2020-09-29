package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

//    @GetMapping
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        List<Blog> blogList = blogService.findAll();
//        modelAndView.addObject("list", blogList);
//        return modelAndView;
//    }

    @ModelAttribute("category")
    public Iterable<Category> category(){
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("list",blogService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/save")
    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        blogService.save(blog);
        modelAndView.addObject("blog", blog);
        return modelAndView;

    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/blog/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        blogService.update(blog.getId(), blog);
        return modelAndView;
    }

    @GetMapping("/blog/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/blog/delete")
    public ModelAndView remove(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        blogService.remove(blog.getId());
        return modelAndView;
    }

    @GetMapping("blog/{id}/views")
    public ModelAndView views(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/view");
       modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }
}

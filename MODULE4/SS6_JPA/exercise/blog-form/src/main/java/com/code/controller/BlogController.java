package com.code.controller;

import com.code.model.Blog;
import com.code.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("list", blogList);
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
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
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
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
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
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
    public ModelAndView views(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
       modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }
}

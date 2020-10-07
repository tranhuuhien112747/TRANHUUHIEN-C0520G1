package com.code.blog.controller;

import com.code.blog.model.Blog;
import com.code.blog.model.Category;
import com.code.blog.model.UserLogin;
import com.code.blog.service.BlogService;
import com.code.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    

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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        accountService.save(new UserLogin("hai", password, "USER", true));
        accountService.save(new UserLogin("tra", password, "CREATOR", true));
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

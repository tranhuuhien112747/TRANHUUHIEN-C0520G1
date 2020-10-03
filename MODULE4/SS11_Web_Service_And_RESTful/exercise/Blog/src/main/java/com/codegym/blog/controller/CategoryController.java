package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    //-------------------Retrieve All Category--------------------------------------------------------

    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    //-------------------Retrieve Single Category--------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id) {
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    //-------------------Create a Category--------------------------------------------------------

    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Category " + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Customer --------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        System.out.println("Updating Category " + id);

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());
        currentCategory.setId(category.getId());

        categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Category with id " + id);

        Category category= categoryService.findById(id);
        if (category == null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.remove(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }







//    @GetMapping
//    public ModelAndView listCategory(@PageableDefault(value = 3) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/category/list");
//        modelAndView.addObject("listCategory", categoryService.findAll(pageable));
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView createCategory() {
//        ModelAndView modelAndView = new ModelAndView("/category/create");
//        modelAndView.addObject("category", new Category());
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/category");
//        categoryService.save(category);
//        modelAndView.addObject("category", category);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}/edit")
//    public ModelAndView editCategory(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/category/edit");
//        modelAndView.addObject("category", categoryService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(@ModelAttribute("category") Category category) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/category");
//        categoryService.update(category.getId(), category);
//        modelAndView.addObject("category", category);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}/delete")
//    public ModelAndView deleteCategory(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/category/delete");
//        modelAndView.addObject("category", categoryService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/delete")
//    public ModelAndView remove(@ModelAttribute("category") Category category) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/category");
//        categoryService.remove(category.getId());
//        modelAndView.addObject("category", category);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}/views")
//    public ModelAndView viewProvince(@PathVariable("id") Long id) {
//        Category category = categoryService.findById(id);
//
//        Iterable<Blog> blog = blogService.findAll();
//
//        ModelAndView modelAndView = new ModelAndView("/category/view");
//        modelAndView.addObject("category", category);
//        modelAndView.addObject("blog", blog);
//        return modelAndView;
//    }

}

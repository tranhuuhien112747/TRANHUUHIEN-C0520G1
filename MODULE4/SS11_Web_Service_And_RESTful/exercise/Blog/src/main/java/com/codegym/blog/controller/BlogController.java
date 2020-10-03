package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
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

//-----------------------------------SHOW ALL LIST--------------------------------------------------------

    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
    }

//    @ModelAttribute("category")
//    public List<Category> category() {
//        return categoryService.findAll();
//    }

    //-------------------------------SHOW SINGLE BLOG---------------------------------
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlogId(@PathVariable("id") long id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

//    @GetMapping
//    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("list",blogService.findAll(pageable));
//        return modelAndView;
//    }

//    @GetMapping("/blog/create")
//    public ModelAndView create() {
//        ModelAndView modelAndView = new ModelAndView("/blog/create");
//        modelAndView.addObject("blog", new Blog());
//        return modelAndView;
//    }

//    @PostMapping("/blog/save")
//    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
//        blogService.save(blog);
//        modelAndView.addObject("blog", blog);
//        return modelAndView;
//
//    }

    //--------------------CREATE-----------------------------------------

    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Blog " + blog.getName());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //----------------------------------------EDIT-UPDATE----------------------------------------------

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") long id, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + id);

        Blog currentBlog = blogService.findById(id);

        if (currentBlog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setName(blog.getName());
        currentBlog.setTitle(blog.getTitle());
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setContent(blog.getContent());
        currentBlog.setId(blog.getId());

        blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }


//    @GetMapping("/blog/{id}/edit")
//    public ModelAndView edit(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/blog/edit");
//        modelAndView.addObject("blog", blogService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/blog/update")
//    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
//        blogService.update(blog.getId(), blog);
//        return modelAndView;
//    }

    //-------------------------------------DELETE-------------------------------------------
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Blog with id " + id);

        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/blog/{id}/delete")
//    public ModelAndView delete(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("/blog/delete");
//        modelAndView.addObject("blog", blogService.findById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/blog/delete")
//    public ModelAndView remove(@ModelAttribute("blog") Blog blog) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
//        blogService.remove(blog.getId());
//        return modelAndView;
//    }

//    @GetMapping("blog/{id}/views")
//    public ModelAndView views(@PathVariable Long id){
//        ModelAndView modelAndView = new ModelAndView("/blog/view");
//        modelAndView.addObject("blog",blogService.findById(id));
//        return modelAndView;
//    }
}

package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.services.ClassStudentService;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
//@SessionAttributes("userInfo")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassStudentService classStudentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        Page<Student> studentList = null;
        if (!keyword.isPresent()) {
            studentList = studentService.findAll(pageable);
        } else {
            studentList = studentService.findByNameContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("students", studentList);

        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam Integer id, Model model) {

        Student student = studentService.findById(id);
        model.addAttribute("studentAbc", student);
        return "detail";
    }

    @GetMapping("/detail/{idStudent}")
    public String showDetailPathVariable(@PathVariable("idStudent") Integer id, Model model) {

        Student student = studentService.findById(id);
        model.addAttribute("studentAbc", student);

        return "detail";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", classStudentService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(value = "student") Student student, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
//        student.setId((int) (Math.random() * 1000));

        new Student().validate(student, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listClass", classStudentService.findAll());
            return "create";
        }

        studentService.save(student);

        redirectAttributes.addFlashAttribute("message", "Register successfully!");

        return "redirect:/list";
    }

}

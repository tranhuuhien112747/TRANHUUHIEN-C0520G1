package com.codegym.books.controller;

import com.codegym.books.exception.GiveBookBackException;
import com.codegym.books.exception.RentBookException;
import com.codegym.books.model.Book;
import com.codegym.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer, Book> bookMap = new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ModelAndView getList() {
        return new ModelAndView("list", "books", bookService.findAll());
    }
    @GetMapping("/book/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }
    @PostMapping("/book/save")
    public ModelAndView save(@ModelAttribute("book") Book book){
        ModelAndView modelAndView=new ModelAndView("redirect:/book");
        bookService.save(book);
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @GetMapping("/toRentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable int id) {
        Book book = bookService.findById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999 - 10000) + 10000;
        if (book == null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView = new ModelAndView("rentBook", "book", book);
        modelAndView.addObject("random", random);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}")
    public ModelAndView rentBook(@ModelAttribute Book book, @PathVariable int random) throws RentBookException {
        if (bookService.rentBook(book)) {
            bookMap.put(random, book);
            System.out.println(random);
            return new ModelAndView("list", "books", bookService.findAll());
        }
        throw new RentBookException();
    }

    @GetMapping("/give_book_back")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("giveBookBack", "random", new Integer("0"));
    }

    @PostMapping("/give_book_back")
    public ModelAndView giveBookBack(@RequestParam int random) throws GiveBookBackException {
        System.out.println(random);
        if (bookMap.containsKey(random)) {
            Book book = bookMap.get(random);
            bookService.giveBookBack(book);
            bookMap.remove(random);
            return new ModelAndView("list", "books", bookService.findAll());
        }else {
            return new ModelAndView("errorGiveBookBack");
        }

    }
}

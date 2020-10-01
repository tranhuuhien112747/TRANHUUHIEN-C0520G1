package com.codegym.books.aspect;

import com.codegym.books.exception.GiveBookBackException;
import com.codegym.books.exception.RentBookException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class Aspect {
    @After("execution(* book.controller.BookController.rentBook(..)),")
    public void writeLog(JoinPoint joinPoint) {
        System.out.println("Hello"+joinPoint.getSignature().getName());
    }
    @ExceptionHandler(RentBookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error");
    }
    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("errorGiveBookBack");
    }
}

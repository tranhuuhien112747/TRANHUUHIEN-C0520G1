package com.codegym.books.service;

import com.codegym.books.model.Book;


public interface BookService {
    Iterable<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void remove(int id);

    boolean rentBook(Book book);

    void giveBookBack(Book book);

}

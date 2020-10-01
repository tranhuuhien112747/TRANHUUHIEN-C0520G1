package com.codegym.books.service;

import com.codegym.books.model.Book;
import com.codegym.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BookServiceImpl implements BookService {
    private static Map<Integer,Book> bookMap = new HashMap<>();

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        bookRepository.deleteById(id);

    }

    @Override
    public boolean rentBook(Book book) {
        for (Book temp: bookRepository.findAll()) {
            bookMap.put(temp.getId(), temp);
        }
        Book temp = bookMap.get(book.getId());
        if (temp.getAmount() == 0) {
            return false;
        } else {
            temp.setAmount(temp.getAmount() - 1);
            bookRepository.save(temp);
            return true;
        }
    }

    @Override
    public void giveBookBack(Book book) {
        Book temp = bookMap.get(book.getId());
        if (temp != null) {
            temp.setAmount(temp.getAmount() + 1);
            bookRepository.save(temp);
        }
    }
}

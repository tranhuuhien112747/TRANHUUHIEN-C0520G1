package com.codegym.books.repository;

import com.codegym.books.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Repository
//public class BookRepositoryImpl implements BookRepository {
//    private static Map<Integer, Book> books = new HashMap<>();
//
//    static {
//        books.put(0, new Book(0, "Codegym", 5));
//        books.put(1, new Book(1, "Naruto", 3));
//        books.put(2, new Book(2, "One piece", 2));
//        books.put(3, new Book(3, "Onizuka", 2));
//    }
//
//    @Override
//    public List<Book> getAllBooks() {
//        return new ArrayList<Book>(books.values());
//    }
//
//    @Override
//    public Book getBookById(int id) {
//        Book book = books.get(id);
//        if (book != null) {
//            return book;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean rentBook(Book book) {
//        Book temp = books.get(book.getId());
//        if (temp.getAmount() == 0) {
//            return false;
//        } else {
//            temp.setAmount(temp.getAmount() - 1);
//            return true;
//        }
//    }
//
//    @Override
//    public void giveBookBack(Book book) {
//        Book temp = books.get(book.getId());
//        if (temp != null) {
//            temp.setAmount(temp.getAmount() + 1);
//        }
//    }
//}

package com.vladblagoci.springbootapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vladblagoci.springbootapp.entity.Book;
import com.vladblagoci.springbootapp.repo.BookRepository;

@RestController
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/find/{id}")
    public Book findBookById(@PathVariable Integer id) {
        return bookRepository.findBookById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestParam String title, @RequestParam String author, @RequestParam Double price) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        return bookRepository.save(book);
    }

    @GetMapping("/findAll")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

}

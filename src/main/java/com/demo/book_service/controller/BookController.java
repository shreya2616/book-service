package com.demo.book_service.controller;

import com.demo.book_service.dao.BookDao;
import com.demo.book_service.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    public BookDao bookDao;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookDao.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getABook(@PathVariable("id") int id){
        return bookDao.findById(id).get();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookDao.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookDao.deleteById(id);
    }
}

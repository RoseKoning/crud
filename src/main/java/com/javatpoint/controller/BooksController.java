package com.javatpoint.controller;

import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/book")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookId") int bookId){
        return booksService.getBooksById(bookId);
    }

    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookId") int bookId){
        booksService.delete(bookId);
    }

    @PostMapping("/books")
    private int saveBooks(@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books.getBookId();
    }

    @PutMapping("/books")
    private Books update (@RequestBody Books books){
        booksService.saveOrUpdate(books);
        return books;
    }
}

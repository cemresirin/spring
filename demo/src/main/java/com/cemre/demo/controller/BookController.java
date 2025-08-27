package com.cemre.demo.controller;

import com.cemre.demo.model.Book;
import com.cemre.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
    return bookService.createBook(book);

    }

    @GetMapping("/list")
    public List<Book>getAllBooks() {
    return bookService.getAllBooks();
}
}

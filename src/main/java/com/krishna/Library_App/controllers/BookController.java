package com.krishna.Library_App.controllers;

import com.krishna.Library_App.entity.Book;
import com.krishna.Library_App.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {


    @Autowired
    public BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @PutMapping("/updateBookById")
    public Book updateBook(@RequestBody Book book)
    {
        return bookService.updateBookAddress(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{bookId}")
    public Book getBookById(@PathVariable int bookId)
    {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable long bookId)
    {
        return bookService.deleteBook(bookId);
    }

}

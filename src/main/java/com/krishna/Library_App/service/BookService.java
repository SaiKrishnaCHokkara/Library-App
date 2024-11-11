package com.krishna.Library_App.service;

import com.krishna.Library_App.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {


   Book updateBookAddress(Book book) ;


    Book addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(long bookId);

    String deleteBook(long bookId);
}

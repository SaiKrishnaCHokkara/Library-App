package com.krishna.Library_App.service.impl;

import com.krishna.Library_App.entity.Book;
import com.krishna.Library_App.repo.BookRepo;
import com.krishna.Library_App.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {


    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
     private BookRepo bookRepo;

    @Override
    public Book addBook(Book book)
    {
        logger.info("Adding Book with id {} ",book.getBookId());
        return bookRepo.save(book);
    }

    @Cacheable( value = "book")
    @Override
    public List<Book> getAllBooks() {
        logger.info("Fetching all the books from db");
        return bookRepo.findAll();
    }

    @Cacheable(key = "#bookId" , value = "book")
    @Override
    public Book getBookById(long bookId)
    {
       Optional<Book> book =bookRepo.findById(bookId);
       if(book.isPresent())
       {
           logger.info("Fetched Book from db");
           return book.get();
       }
       else{
           logger.info("Adding new book to db");
           return new Book();
       }


    }

    @CacheEvict(key = "#bookId" , value = "book")
    @Override
    public String deleteBook(long bookId) {
        bookRepo.deleteById(bookId);
        logger.info("Book deleted from db ");
        return "Book Deleted";
    }

    @CachePut(key = "#book.bookId" , value = "book")
    @Override
    public Book updateBookAddress(Book book) {
       logger.info("Updating book name By Id",book.getBookName() + "By Id ",book.getBookId());

       bookRepo.updateAddress(book.getBookId(), book.getBookName());

        return book;
    }



}

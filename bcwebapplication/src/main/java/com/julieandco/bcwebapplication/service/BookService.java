package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.BookDTO;
import com.julieandco.bcwebapplication.entities.CustomerDTO;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import com.julieandco.bcwebapplication.repo.BookRepository;
import com.julieandco.bcwebapplication.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(final BookDTO bookData) {
        Book book = populateBookData(bookData);
        return bookRepository.save(book);
    }
    private Book populateBookData(final BookDTO bookData) {
        Book book = new Book();
        book.setTitle(bookData.getTitle());
        book.setAuthor(bookData.getAuthor());
        book.setYear(bookData.getYear());
        book.setGenre(bookData.getGenre());
        return book;
    }

    @Transactional
    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    @Transactional
    public Book findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

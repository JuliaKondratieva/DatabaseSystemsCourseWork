package com.julieandco.bcwebapplication.controllers;

import com.google.gson.*;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BookRestController {
    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books")
    public String getAllBooks()
    {
        List<Book> books;
        String jsonstring="";
        books=bookService.getAllBooks();
        for (Book book:books) {
            Book bookObj = book;
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            jsonstring=jsonstring+gson.toJson(bookObj);
        }

        return jsonstring;
    }
}

package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.BookDTO;
import com.julieandco.bcwebapplication.entities.CustomerDTO;
import com.julieandco.bcwebapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
public class BookController {
    private final BookService bookService;
    private static final String ADDPAGE ="welcome";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/addBook")
    public String getRegistrationView(){
        return "addBook";
    }

    @PostMapping("/addBook")
    public String bookRegistration(final BookDTO bookDTO, final Model model){
        if(bookService.findByTitle(bookDTO.getTitle())==null)
                bookService.saveBook(bookDTO);
        return ADDPAGE;
    }

    @GetMapping("/getBook")
    public String getCatalogueView(){
        return "book";
    }

    @RequestMapping(value = "/getBook")
    public String getAllBooksJSON(Model model)
    {
        model.addAttribute("books", bookService.getAllBooks());
        return "book";
    }
}

package com.julieandco.bcwebapplication.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.entities.Box;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.BoxService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoxRestController {
    private final BoxService boxService;
    private final OrderService orderService;

    @Autowired
    public BoxRestController(BoxService boxService, OrderService orderService) {
        this.boxService = boxService;
        this.orderService=orderService;
    }

    @RequestMapping(value = "/box")
    public String getBoxInfo()
    {
        String bookstring="";
        Box boxser=boxService.findByAddress("Khreshchatyk");
        List<Book> bl;
               bl= boxser.getBooks();
        String res="BOOKS: ";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        List<Bookorder> listord=new ArrayList<>();
        Bookorder order=new Bookorder();
        if(bl!=null)
       for(Book book:bl){
            listord.add(orderService.findCurrentByBook(book));
       }
       String ord="ORDERS: ";

        bookstring=res+gson.toJson(bl)+ord+gson.toJson(listord);
        return bookstring;
    }
}

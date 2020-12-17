package com.julieandco.bcwebapplication.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public class OrderRestController {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final CustomerService customerService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    public OrderRestController(OrderService orderService,CustomerService customerService) {
        this.orderService = orderService;
        this.customerService=customerService;
    }

    @RequestMapping(value = "/orders")
    public String getUserOrders()
    {
        List<Bookorder> bookorders;
        String jsonstring="";
        String email=httpServletRequest.getRemoteUser();
        bookorders=orderService.findByCustomerEntity(customerService.findByUsername(email));
        for (Bookorder orders:bookorders) {
            Bookorder orderObj = orders;
            String orderstr="ORDER N0: "+orders.getId().toString()
                    + "    BOOK:  "+orders.getBook().getTitle()
                    + "    "+ orders.statusString();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            jsonstring=jsonstring+gson.toJson(orderstr);
        }

        return jsonstring;
    }

    @RequestMapping(value = "/allorders")
    public String getAllOrders()
    {
        List<Bookorder> bookorders;
        String jsonstring="";
        bookorders=orderService.getAllOrders();
        for (Bookorder orders:bookorders) {
            Bookorder orderObj = orders;
            String orderstr="ORDER N0: "+orders.getId().toString()
                    + "    BOOK:  "+orders.getBook().getTitle()
                    + "    USER:  "+orders.getUser().getEmail()
                    + "    "+ orders.statusString();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            jsonstring=jsonstring+gson.toJson(orderstr);
        }

        return jsonstring;
    }
}

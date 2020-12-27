package com.julieandco.bcwebapplication.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

   /* @RequestMapping("/myorders")
    public ModelAndView OrdersPage(Model model) {
        List<OrderEntity> listOrders = new ArrayList<>();
        String email=httpServletRequest.getRemoteUser();
        List<Bookorder> bookorders=orderService.findByCustomerEntity(customerService.findByUsername(email));
        for (Bookorder orders:bookorders) {
            OrderEntity entity = new OrderEntity(orders.getBook().getTitle());
            entity.setId(orders.getId());
            entity.setDueDate(orders.getDueDate().toLocalDate());
            entity.setFromDate(orders.getFromDate().toLocalDate());
            if(!orders.getDeliveryState()){
                if(orders.getSubmitted())
                    entity.setStatus("Submitted");
                else
                    entity.setStatus("Waiting list");
            }
            else
                entity.setStatus("Delivered");
            listOrders.add(entity);
        }
        model.addAttribute("listOrders", listOrders);

        return new ModelAndView("myorders");
    }*/

    /*@RequestMapping("/allorders")
    public ModelAndView OrdersAdmPage(Model model) {
        List<Bookorder> listOrders = new ArrayList<>();
        List<Bookorder> bookorders=orderService.getAllOrders();
        for (Bookorder orders:bookorders) {

            if(orders.getSubmitted()&& !orders.getDeliveryState())
                listOrders.add(orders);
        }
        model.addAttribute("listOrders", listOrders);

        return new ModelAndView("allorders");
    }*/

    /*@RequestMapping(value = "/orders")
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
    }*/

    /*@RequestMapping(value = "/allorders")
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
    }*/
}

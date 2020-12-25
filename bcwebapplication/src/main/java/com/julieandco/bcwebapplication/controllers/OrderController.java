package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    private static final String D_PAGE ="mainuserpage";
    private static final String WAITING_LIST_PAGE ="waitinglist";


    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    @GetMapping("/ordersubmit")
    public String getRegistrationView(){
        return "ordersubmit";
    }

    @PostMapping("/ordersubmit")
    public String orderSubmitting(final BookSave book, final Model model){
        System.out.println("CONTROLLER CHECK\n");
        System.out.println("TITLE: "+book.getTitle());
        Book ordered = bookService.findByTitle(book.getTitle());
        System.out.println("CHECK CONTROLLER BOOK= "+ordered.getTitle());
        String username = httpServletRequest.getRemoteUser();
        System.out.println("CONTROLLER. USER: "+username);

        List<Bookorder> bybook;
        bybook=orderService.findByBook(ordered);
        System.out.println("CHECK LOOP\n");
        for(int i=0; i< bybook.size();++i){
            System.out.println("i="+i+bybook.get(i).getBook().getTitle());
        }
        if(bybook.size()>0) {
            System.out.println("BYBOOK ISNT NULL");
            BookorderDTO bookorderDTO=new BookorderDTO(ordered,customerService.findByUsername(username));
            orderService.addOrder(bookorderDTO);
            return WAITING_LIST_PAGE;
        }
        else {
            System.out.println("BYBOOK IS NULL");
            BookorderDTO bookorderDTO=new BookorderDTO(ordered,customerService.findByUsername(username));
            orderService.addOrder(bookorderDTO);
            return D_PAGE;
        }

    }
}

package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.BoxService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class DeliveryController {
    private static final String DELIVERY_PAGE ="delivery";
    @Autowired
    private OrderService orderService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/delivery")
    public String getDeliveryView(){
        return "delivery";
    }

    /*@RequestMapping(value = "/subm/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") String id, HttpServletRequest request) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);
        try {
            Book book = bookService.findById(idd).get();
            CustomerEntity user = customerService.findByUsername(request.getRemoteUser());
            BookorderDTO orderdto = new BookorderDTO(book, user);
            orderService.addOrder(orderdto);

            if (orderService.findByBook(book).size() == 1)
                return new ModelAndView("submit");
            else
                return new ModelAndView("waitinglist");
        }
        catch (NoSuchElementException exception){
            return new ModelAndView("errorelement");
        }
        //return new ModelAndView("submit");
    }*/

    /*@RequestMapping(value = "/deliver/{id}")
    public ModelAndView returnPage(@PathVariable(name = "id") String id) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);
        try {
            Bookorder order = orderService.findById(idd).get();
            //check in to box & order delete or change status
            boxService.returnOrder(order);
            return new ModelAndView("mainuserpage");
        }
        catch (NoSuchElementException exception){
            return new ModelAndView("errorelement");
        }
        //return new ModelAndView("submit");
    }*/

    /*@RequestMapping(value = "/boxdelivery/{id}")
    public ModelAndView deliverPage(@PathVariable(name = "id") String id) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);
        try {
            Bookorder order = orderService.findById(idd).get();
            //check in to box & order delete or change status
            boxService.delivOrder(order);
            return new ModelAndView("adminpage");
        }
        catch (NoSuchElementException exception){
            return new ModelAndView("errorelement");
        }
        //return new ModelAndView("submit");
    }*/

   /* @PostMapping("/delivery")
    public String deliveryCheckIn(final BookDTO bookDTO, final Model model){
        Bookorder updated;
        System.out.println("DELIVERY"+bookDTO.getYear());
        Optional<Bookorder> opt;
       //System.out.println("ID: "+bookorderDTO.getId());
        Long idd=Long.valueOf(String.valueOf(bookDTO.getYear()));
        opt=orderService.findById(idd);
        System.out.println("OPTOPT: "+opt.get().getId());
        if(opt.isEmpty())
            return DELIVERY_PAGE;
        updated= opt.get();
        updated.setDeliveryState(true);
        updated.setId(idd);
        orderService.saveOrder(updated);
        Box boxtoadd=new Box();
        boxtoadd=boxService.findByAddress("Khreshchatyk");
        Book book=new Book();
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setYear(bookDTO.getYear());
        book.setGenre(book.getGenre());
        boxService.addBook(boxtoadd, book);
        return DELIVERY_PAGE;
    }*/
}

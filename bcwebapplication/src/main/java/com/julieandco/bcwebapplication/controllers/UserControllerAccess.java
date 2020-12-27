package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.BoxService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserControllerAccess {

    @Autowired
    private BookService bookService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/catalogue")
    public ModelAndView viewHomePage(Model model) {
        List<Book> listBooks = bookService.getAllBooks();
        model.addAttribute("listBooks", listBooks);

        return new ModelAndView("temp");
    }

    @RequestMapping(value="/waitinglist")
    public ModelAndView listmessage() {
        return new ModelAndView("waitinglist");
    }

    @RequestMapping("/userpage")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteUser().toString());
        return new ModelAndView("mainuserpage");
    }

    @RequestMapping(value = "/subm/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") String id, HttpServletRequest request) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);

            Book book = bookService.findById(idd).get();
            CustomerEntity user = customerService.findByUsername(request.getRemoteUser());
            BookorderDTO orderdto = new BookorderDTO(book, user);
            orderService.addOrder(orderdto);

            if (orderService.findByBook(book).size() == 1)
                return new ModelAndView("submit");
            else
                return new ModelAndView("waitinglist");


        //return new ModelAndView("submit");
    }

    @RequestMapping(value = "/deliver/{id}")
    public ModelAndView returnPage(@PathVariable(name = "id") String id) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);

            Bookorder order = orderService.findById(idd).get();
            //check in to box & order delete or change status
            boxService.returnOrder(order);
            return new ModelAndView("mainuserpage");

        //return new ModelAndView("submit");
    }

    @RequestMapping("/myorders")
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
    }
}

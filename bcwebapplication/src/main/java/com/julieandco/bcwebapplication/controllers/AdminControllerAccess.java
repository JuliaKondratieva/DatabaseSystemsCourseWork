package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.BoxService;
import com.julieandco.bcwebapplication.service.CustomerService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminControllerAccess {
    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private OrderService orderService;
    private static final String ADDPAGE ="adminpage";

    @RequestMapping(value="/adminpage")
    public ModelAndView admin(HttpServletRequest request)
    {
        if (request.isUserInRole("USER")) {
            System.out.println("DENIED");
            //throw new AccessDeniedException("");
            return new ModelAndView("mainuserpage");
        }
        return new ModelAndView("adminpage");
    }

    @RequestMapping("/allusers")
    public ModelAndView viewHomePage(Model model) {
        List<CustomerEntity> listUsers = customerService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return new ModelAndView("users");
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

    /*@RequestMapping("/adminpage")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteUser().toString());
        return new ModelAndView("adminpage");
    }*/

    @GetMapping("/addBox")
    public String getRegistrationBoxView(){
        return "boxadd";
    }

    @PostMapping("/addBox")
    public String bookRegistration(final BoxDTO boxDTO, final Model model){
        boxService.saveBox(boxDTO.getAddress());
        return ADDPAGE;
    }

    @RequestMapping(value = "/boxdelivery/{id}")
    public ModelAndView deliverPage(@PathVariable(name = "id") String id) {
        //ModelAndView mav = new ModelAndView("edit_product");
        System.out.println("CONSTRUCTION ID: "+id);
        Long idd=Long.valueOf(id);
        System.out.println("TO LONG: "+idd);

            Bookorder order = orderService.findById(idd).get();
            //check in to box & order delete or change status
            boxService.delivOrder(order);
            return new ModelAndView("adminpage");

        //return new ModelAndView("submit");
    }

    @RequestMapping("/allorders")
    public ModelAndView OrdersAdmPage(Model model) {
        List<Bookorder> listOrders = new ArrayList<>();
        List<Bookorder> bookorders=orderService.getAllOrders();
        for (Bookorder orders:bookorders) {

            if(orders.getSubmitted()&& !orders.getDeliveryState())
                listOrders.add(orders);
        }
        model.addAttribute("listOrders", listOrders);

        return new ModelAndView("allorders");
    }
}

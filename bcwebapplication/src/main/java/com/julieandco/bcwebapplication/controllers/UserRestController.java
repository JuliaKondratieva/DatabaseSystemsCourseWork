package com.julieandco.bcwebapplication.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserRestController {
    private final CustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*@RequestMapping("/allusers")
    public ModelAndView viewHomePage(Model model) {
        List<CustomerEntity> listUsers = customerService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return new ModelAndView("users");
    }*/

    /*@RequestMapping(value = "/allusers")
    public String getAllUsers()
    {
        List<CustomerEntity> users;
        String jsonstring="";
        users=customerService.getAllUsers();
        for (CustomerEntity customer:users) {
            CustomerEntity userObj = customer;
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            jsonstring=jsonstring+gson.toJson(userObj);
        }

        return jsonstring;
    }*/
}

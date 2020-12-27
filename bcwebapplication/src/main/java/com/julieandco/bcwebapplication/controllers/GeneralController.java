package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.Role;
import com.julieandco.bcwebapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GeneralController {
    @RequestMapping(value="/welcome")
    public ModelAndView welcomepage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/homepage")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteUser().toString());
        System.out.println(customerService.findByUsername(request.getRemoteUser()).getRoles());
        Role cusRole = Role.ADMIN;
        if (customerService.findByUsername(request.getRemoteUser()).getRoles().contains(cusRole)){
            System.out.println("REMOTEUSERADMIN");
            return new ModelAndView("adminpage");
        }
        System.out.println("RU USER");
        return new ModelAndView("mainuserpage");
    }
}

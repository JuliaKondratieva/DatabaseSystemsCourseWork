package com.julieandco.bcwebapplication;

import com.julieandco.bcwebapplication.entities.CustomerDTO;
import com.julieandco.bcwebapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private static final String REGISTRATION_CONFIRMATION_PAGE ="registrationConfirmation";
    private static final String ERROR_REGISTRATION ="registrationError";

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String getRegistrationView(){
        return "registration";
    }

    @PostMapping("/register")
    public String customerRegistration(final CustomerDTO customer, final Model model){
        if(customerService.findByEmail(customer.getEmail())!=null||customerService.findByUsername(customer.getUsername())!=null)
            return ERROR_REGISTRATION;
        customerService.saveCustomer(customer);
        return REGISTRATION_CONFIRMATION_PAGE;
    }
}

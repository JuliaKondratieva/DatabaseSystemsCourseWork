package com.julieandco.bcwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationAuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;


   /* public void registerNewUserAccount(User customerProfile) throws EmailExistsException {
        if (customerService.findByEmail(customerProfile.getMail())!=null) {
            throw new EmailExistsException(
                    "There is an account with that email adress:" + customerProfile.getMail());
        }
        User customer = new User(customerProfile.getUsername(), customerProfile.getMail(), passwordEncoder.encode(customerProfile.getPassword()));
        customer.addRole(1, "user");
        customerService.saveUser(customer);*/
    }


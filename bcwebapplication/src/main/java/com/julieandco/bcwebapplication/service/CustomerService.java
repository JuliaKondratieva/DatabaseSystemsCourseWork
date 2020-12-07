package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.entities.CustomerDTO;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import com.julieandco.bcwebapplication.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public CustomerEntity saveCustomer(final CustomerDTO customerData) {
        CustomerEntity customerModel = populateCustomerData(customerData);
        return customerRepository.save(customerModel);
    }

    private CustomerEntity populateCustomerData(final CustomerDTO customerData) {
        CustomerEntity customer = new CustomerEntity();
        customer.setUsername(customerData.getUsername());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(passwordEncoder.encode(customerData.getPassword()));
        return customer;
    }

    @Transactional
    public CustomerEntity findByEmail(String mail){
        return customerRepository.findByEmail(mail);
    }

    @Transactional
    public CustomerEntity findByUsername(String username){
        return customerRepository.findByUsername(username);
    }
}


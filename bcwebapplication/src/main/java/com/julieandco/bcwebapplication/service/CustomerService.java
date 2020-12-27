package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.entities.CustomerDTO;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import com.julieandco.bcwebapplication.entities.Role;
import com.julieandco.bcwebapplication.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public CustomerEntity saveCustomer(final CustomerDTO customerData) {
        CustomerEntity ent = populateCustomerData(customerData);
        ent.setRoles(Collections.singleton(Role.USER));
        //CustomerEntity customerModel = populateCustomerData(customerData);
        return customerRepository.save(ent);
    }

    public boolean saveAdmin(CustomerDTO user) {
        CustomerEntity ent = populateCustomerData(user);
        ent.setRoles(Collections.singleton(Role.ADMIN));
        customerRepository.save(ent);
        return true;
    }

    @Transactional
    public void deleteUser(CustomerDTO customerDTO){
        customerRepository.delete(populateCustomerData(customerDTO));
    }

    private CustomerEntity populateCustomerData(final CustomerDTO customerData) {
        CustomerEntity customer = new CustomerEntity();
        customer.setUsername(customerData.getUsername());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(passwordEncoder.encode(customerData.getPassword()));
        return customer;
    }
    @Transactional
    public List<CustomerEntity> getAllUsers() {
        return customerRepository.findAll();
    }

    @Transactional
    public CustomerEntity findByEmail(String mail){
        return customerRepository.findByEmail(mail);
    }

    @Transactional
    public CustomerEntity findByUsername(String username){
        return customerRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomerEntity user = customerRepository.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}


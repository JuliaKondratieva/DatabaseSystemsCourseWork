package com.julieandco.bcwebapplication;

import com.julieandco.bcwebapplication.entities.CustomerEntity;
import com.julieandco.bcwebapplication.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final CustomerEntity customer = customerRepository.findByUsername(username);
        if(customer ==null){
            System.out.println("NULL");
            throw new UsernameNotFoundException(username);
        }
        UserDetails user;
        if(username.equals("your_admin"))
        {
            System.out.println("ADMIN USER");
            user = User.withUsername(customer.getUsername()).password(customer.getPassword()).authorities("ADMIN").build();
        }
        else
             user = User.withUsername(customer.getUsername()).password(customer.getPassword()).authorities("USER").build();
        return user;
    }
}

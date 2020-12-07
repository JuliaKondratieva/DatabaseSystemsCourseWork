package com.julieandco.bcwebapplication.repo;

import com.julieandco.bcwebapplication.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
    CustomerEntity findByUsername(String username);
}

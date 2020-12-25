package com.julieandco.bcwebapplication.repo;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
    Box findByAddress(String address);
}

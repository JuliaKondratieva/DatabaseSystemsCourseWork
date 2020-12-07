package com.julieandco.bcwebapplication.repo;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Bookorder, Long> {
    List<Bookorder> findByBook(Book book);
    List<Bookorder> findByCustomer(CustomerEntity customerEntity);

}

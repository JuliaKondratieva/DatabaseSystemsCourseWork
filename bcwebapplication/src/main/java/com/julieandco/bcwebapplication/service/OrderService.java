package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.repo.BookRepository;
import com.julieandco.bcwebapplication.repo.CustomerRepository;
import com.julieandco.bcwebapplication.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository userRepository;

    @Autowired
    public OrderService(BookRepository bookRepository, OrderRepository orderRepository, CustomerRepository userRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public List<Bookorder> findByBook(Book book){
        return orderRepository.findByBook(book);
    }

    @Transactional
    public List<Bookorder> findByCustomerEntity(CustomerEntity customerEntity){
        return orderRepository.findByCustomer(customerEntity);
    }

    /*public Bookorder saveOrder(final BookorderDTO orderData) {
        Bookorder order = populateOrderData(orderData);
        return orderRepository.save(order);
    }*/
    @Transactional
    public void saveOrder(Bookorder order) {
         orderRepository.save(order);
    }

    private Bookorder populateOrderData(final BookorderDTO orderData) {
        Bookorder order = new Bookorder();
        order.setBook(orderData.getBook());
        order.setUser(orderData.getUser());
        return order;
    }

    public Bookorder findCurrentByBook(Book book){
        Bookorder bookorder=new Bookorder();
        List<Bookorder> list = orderRepository.findByBook(book);
        for(Bookorder order:list){
            if(order.getSubmitted())
                bookorder=order;
        }
        return bookorder;
    }

    @Transactional
    public List<Bookorder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void addOrder(BookorderDTO bookorderDTO){
        System.out.println("ADD order SERVICE\n");
        Book bookel=bookRepository.findByTitle(bookorderDTO.getBook().getTitle());
        CustomerEntity user1=userRepository.findByEmail(bookorderDTO.getUser().getEmail());
        Bookorder newOrder;
        newOrder = null;

        if(orderRepository.findByBook(bookel).size()==0) {
            System.out.println("IF. IS NULL");
            newOrder = new Bookorder(bookel, user1);
            newOrder.setSubmitted(true);
            orderRepository.save(newOrder);
        }

        else{
            System.out.println("ELSE. ISNT NULL");
            newOrder=new Bookorder(bookel, user1);
            newOrder.setSubmitted(false);
            orderRepository.save(newOrder);
        }

    }
    @Transactional
    public Optional<Bookorder> findById(Long id){
        return orderRepository.findById(id);
    }

}

package com.julieandco.bcwebapplication.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class BookorderDTO {
    private Long id;
    private Book book;
    private CustomerEntity customer;
    private LocalDateTime fromDate;
    private LocalDateTime dueDate;
    private boolean deliveryState;
    private boolean submitted;

    public BookorderDTO()
    {
        book=new Book();
        customer=new CustomerEntity();
        deliveryState=false;
        submitted=true;
    }

    public BookorderDTO(Book book, CustomerEntity user){
        this.book=book;
        this.customer=user;
        this.fromDate=LocalDateTime.now();
        this.dueDate=fromDate.plusWeeks(3);
        this.deliveryState=false;
        this.submitted=true;
    }

    public Book getBook(){
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getSubmitted() {
        return submitted;
    }

    public void setDeliveryState(boolean deliveryState) {
        this.deliveryState = deliveryState;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public CustomerEntity getUser(){
        return customer;
    }

    public void setUser(CustomerEntity user) {
        this.customer = user;
    }

    public void isDelivered(){
        this.deliveryState=true;
    }

    public boolean getDeliveryState(){
        return deliveryState;
    }

    public LocalDateTime getDueDate(){
        return dueDate;
    }
}

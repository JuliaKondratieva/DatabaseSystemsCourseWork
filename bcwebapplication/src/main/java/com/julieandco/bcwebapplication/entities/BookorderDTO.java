package com.julieandco.bcwebapplication.entities;

import java.time.LocalDate;
import java.util.UUID;

public class BookorderDTO {
    private Long id;
    private Book book;
    private CustomerEntity customer;
    private LocalDate fromDate;
    private LocalDate dueDate;
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
        this.fromDate=LocalDate.now();
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
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

    public void setFromDate(LocalDate fromDate) {
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

    public LocalDate getDueDate(){
        return dueDate;
    }
}

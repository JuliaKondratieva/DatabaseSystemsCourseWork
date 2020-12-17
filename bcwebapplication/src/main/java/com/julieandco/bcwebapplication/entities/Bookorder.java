package com.julieandco.bcwebapplication.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bookorder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private CustomerEntity customer;
    @Column
    private LocalDateTime fromDate;
    @Column
    private LocalDateTime dueDate;
    @Column
    private boolean deliveryState;
    @Column
    private boolean submitted;

    public Bookorder()
    {

    }

    public Bookorder(Book book, CustomerEntity user){
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

    public String statusString(){
        if(submitted)
            return "STATUS: SUBMITTED. DUE DATE: "+dueDate.toString();
        else
            return "STATUS: IN WAITING LIST";
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
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

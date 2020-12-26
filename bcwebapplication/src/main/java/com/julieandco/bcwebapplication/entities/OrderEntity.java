package com.julieandco.bcwebapplication.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderEntity {
    private Long id;
    private String book;
    private LocalDate fromDate;
    private LocalDate dueDate;
    private String status;

    public OrderEntity()
    {
    }

    public OrderEntity(String book){
        this.book=book;
        this.fromDate=LocalDate.now();
        this.dueDate=fromDate.plusWeeks(3);
        this.status="Submitted";
    }

    public String getBook(){
        return book;
    }

    public void setBook(String book) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }
}

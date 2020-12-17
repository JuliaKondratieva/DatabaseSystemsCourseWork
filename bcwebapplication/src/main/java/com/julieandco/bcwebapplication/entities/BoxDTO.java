package com.julieandco.bcwebapplication.entities;

import java.util.List;

public class BoxDTO {
    private List<BookDTO> books;
    private String address;


    public BoxDTO() {
    }

    public BoxDTO(List<BookDTO> books) {
        this.books = books;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

}

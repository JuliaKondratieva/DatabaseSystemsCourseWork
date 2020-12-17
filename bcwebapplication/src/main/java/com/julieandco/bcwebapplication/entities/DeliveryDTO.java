package com.julieandco.bcwebapplication.entities;

public class DeliveryDTO {
    private Long bookorder;
    private Long box;

    public DeliveryDTO(Long bookorder, Long box) {
        this.bookorder = bookorder;
        this.box = box;
    }

    public void setBox(Long box) {
        this.box = box;
    }

    public Long getBookorder() {
        return bookorder;
    }

    public void setBookorder(Long bookorder) {
        this.bookorder = bookorder;
    }

    public Long getBox() {
        return box;
    }
}

package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.BookDTO;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.entities.Box;
import com.julieandco.bcwebapplication.repo.BookRepository;
import com.julieandco.bcwebapplication.repo.BoxRepository;
import com.julieandco.bcwebapplication.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoxService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final BoxRepository boxRepository;

    public BoxService(BookRepository bookRepository, OrderRepository orderRepository, OrderService orderService, BoxRepository boxRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.orderService=orderService;
        this.boxRepository=boxRepository;
    }


    public void saveBox(String Address) {
        Box box = new Box();
        box.setAddress(Address);
        if(boxRepository.findByAddress(Address)==null)
            boxRepository.save(box);
    }

    @Transactional
    public Box findByAddress(String address){
        return boxRepository.findByAddress(address);
    }

    @Transactional
    public void checkinbook(Book book){

    }

    public void returnOrder(Bookorder bookorder){
        if (bookorder.getDeliveryState()) {
            Box boxkhr = findByAddress("Khreshchatyk");
            addBook(boxkhr, bookorder.getBook());
            //Bookorder current = orderService.findCurrentByBook(bookorder.getBook());
            //orderService.deleteOrder(current);
        }
    }

    public void delivOrder(Bookorder bookorder){
        Box boxkhr = findByAddress("Khreshchatyk");
        addBook(boxkhr, bookorder.getBook());
        bookorder.setDeliveryState(true);
        orderService.saveOrder(bookorder);
    }

    @Transactional
    public void addBook(Box box, Book receivedBook) {
        System.out.println("START OF ADDBOOK");
        Bookorder recOrder = null;
        List<Bookorder> byBookId = new ArrayList<>();
        List<Bookorder> nextOrderQueue = new ArrayList<>();

        Bookorder nextOrder = null;
        Book bookres = bookRepository.findByTitle(receivedBook.getTitle());
        byBookId=orderRepository.findByBook(bookres);
        for(Bookorder o: byBookId){
            if(o.getSubmitted())
                recOrder=o;
            System.out.println("RECORDER"+o.toString());
        }

        System.out.println("RECORDERAFTERFOR"+ (recOrder==null?"NULL":recOrder.toString()));

        if(recOrder!=null){
            Box toBox = boxRepository.findByAddress(box.getAddress());
            bookRepository.save(recOrder.getBook());

            nextOrderQueue=orderRepository.findByBook(bookres);
            if(!nextOrderQueue.isEmpty()) {
                System.out.println("nextordernot empty");
                LocalDateTime min = LocalDateTime.now();
                for (Bookorder o : nextOrderQueue) {
                    if (min.isAfter(o.getFromDate())&&o.getId()!=recOrder.getId()) {
                        min = o.getFromDate();
                        nextOrder = o;
                    }
                    System.out.println("O in for"+o.toString());
                }
            }
            System.out.println(recOrder.getDeliveryState());
            System.out.println(recOrder.getSubmitted());
            if(recOrder.getDeliveryState()||!recOrder.getSubmitted()) {
                System.out.println(nextOrder);

                if (nextOrder == null) {
                    orderRepository.delete(recOrder);
                } else {
                    orderRepository.delete(recOrder);
                    nextOrder.setSubmitted(true);
                    nextOrder.setFromDate(LocalDateTime.now());
                    orderRepository.save(nextOrder);
                    System.out.println(nextOrder.getUser().getUsername() + ", Your Order was submitted. Expect!");
                }
            }
        }
        List<Book> ofbooks=new ArrayList<>();
        if(box.getBooks()==null) {
            ofbooks.add(receivedBook);
            box.setBooks(ofbooks);
            System.out.println("LASTIFNULL");
        }
        else
        box.getBooks().add(receivedBook);
        boxRepository.save(box);
    }

}

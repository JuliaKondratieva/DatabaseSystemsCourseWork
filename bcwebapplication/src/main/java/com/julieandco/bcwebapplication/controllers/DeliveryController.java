package com.julieandco.bcwebapplication.controllers;

import com.julieandco.bcwebapplication.entities.BookDTO;
import com.julieandco.bcwebapplication.entities.Bookorder;
import com.julieandco.bcwebapplication.entities.BookorderDTO;
import com.julieandco.bcwebapplication.entities.DeliveryDTO;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DeliveryController {
    private static final String DELIVERY_PAGE ="delivery";
    @Autowired
    private OrderService orderService;
    @GetMapping("/delivery")
    public String getDeliveryView(){
        return "delivery";
    }

    @PostMapping("/delivery")
    public String deliveryCheckIn(final BookDTO bookDTO, final Model model){
        Bookorder updated;
        System.out.println("DELIVERY"+bookDTO.getYear());
        Optional<Bookorder> opt;
       //System.out.println("ID: "+bookorderDTO.getId());
        Long idd=Long.valueOf(String.valueOf(bookDTO.getYear()));
        opt=orderService.findById(idd);
        System.out.println("OPTOPT: "+opt.get().getId());
        if(opt.isEmpty())
            return DELIVERY_PAGE;
        updated= opt.get();
        updated.setDeliveryState(true);
        updated.setId(idd);
        orderService.saveOrder(updated);
        return DELIVERY_PAGE;
    }
}

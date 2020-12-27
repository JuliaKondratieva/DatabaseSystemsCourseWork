package com.julieandco.bcwebapplication.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bcwebapplication.entities.*;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.BoxService;
import com.julieandco.bcwebapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoxRestController {
    private final BoxService boxService;
    private final OrderService orderService;
    private static final String ADDPAGE ="adminpage";

    @Autowired
    public BoxRestController(BoxService boxService, OrderService orderService) {
        this.boxService = boxService;
        this.orderService=orderService;
    }

    /*@GetMapping("/addBox")
    public String getRegistrationView(){
        return "boxadd";
    }

    @PostMapping("/addBox")
    public String bookRegistration(final BoxDTO boxDTO, final Model model){
        boxService.saveBox(boxDTO.getAddress());
        return ADDPAGE;
    }

    @RequestMapping("/boxinfo")
    public ModelAndView viewBoxPage(Model model) {
        List<Box> listBoxs = boxService.getAll();
        System.out.println("AH HERE WE GO"+listBoxs.get(0).toString());
        model.addAttribute("listBoxs", listBoxs);
        return new ModelAndView("boxstore");
    }*/
}

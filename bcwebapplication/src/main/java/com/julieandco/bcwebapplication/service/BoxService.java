package com.julieandco.bcwebapplication.service;

import com.julieandco.bcwebapplication.repo.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;
}

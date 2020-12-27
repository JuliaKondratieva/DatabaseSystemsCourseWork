package com.julieandco.bcwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationAuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    }


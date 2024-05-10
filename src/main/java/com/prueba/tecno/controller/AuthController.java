package com.prueba.tecno.controller;

import com.prueba.tecno.service.Authservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private Authservice authservice;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestHeader(required = false) final String email,
            @RequestHeader(required = false) final String password
    ) {
        return authservice.login(email, password);
    }
}

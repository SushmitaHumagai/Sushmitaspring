package com.nextstep.springauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ResponseApi {

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('User')")
    @GetMapping("/health")
    public ResponseEntity<String>health(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}

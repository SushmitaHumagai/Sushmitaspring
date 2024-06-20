package com.nextstep.springauth.controller;

import com.nextstep.springauth.model.SignUpModel;
import com.nextstep.springauth.service.Auth;
import com.nextstep.springauth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class SignUpController {
@Autowired
    Auth auth;
@Autowired
AuthenticationManager authenticationManager;
@Autowired
JwtService jwtService;

@PostMapping("/saveSignUp")
    public ResponseEntity<String>saveSignUpDetails(@Valid @RequestBody SignUpModel signUpModel){
    auth.saveSignUpDetails(signUpModel);
    return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
}

@PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody SignUpModel signUpModel){
    Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signUpModel.getUsername(),signUpModel.getPassword()));
    if (authentication.isAuthenticated()){
        String token=jwtService.GenerateToken(signUpModel.getUsername());
        return new ResponseEntity<>(token,HttpStatus.OK);
    }
    return new ResponseEntity<>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
}
}

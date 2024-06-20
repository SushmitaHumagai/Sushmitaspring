package com.nextstep.springauth.service;

import com.nextstep.springauth.model.SignUpModel;
import com.nextstep.springauth.repo.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthImpl implements Auth {
    @Autowired
    SignUpRepo signUpRepo;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveSignUpDetails(SignUpModel signUpModel) {

        signUpModel.setPassword(passwordEncoder.encode(signUpModel.getPassword()));
        signUpRepo.save(signUpModel);
    }
}

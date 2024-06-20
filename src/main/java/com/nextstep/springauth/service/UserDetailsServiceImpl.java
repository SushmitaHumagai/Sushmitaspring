package com.nextstep.springauth.service;


import com.nextstep.springauth.model.SignUpModel;
import com.nextstep.springauth.repo.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SignUpRepo signUpRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SignUpModel user = signUpRepo.findByUsername(username);
        if( user == null){

            throw new UsernameNotFoundException("could not found user..!!");
        }
        return new UserDetailInfo(user);
    }
}


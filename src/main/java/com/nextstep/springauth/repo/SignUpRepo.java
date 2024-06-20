package com.nextstep.springauth.repo;


import com.nextstep.springauth.model.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepo extends JpaRepository<SignUpModel,Integer > {
    public SignUpModel findByUsername(String username);
}

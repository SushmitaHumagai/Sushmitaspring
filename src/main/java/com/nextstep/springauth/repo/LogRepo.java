package com.nextstep.springauth.repo;

import com.nextstep.springauth.model.LogBookModel;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<LogBookModel,Integer> {
}

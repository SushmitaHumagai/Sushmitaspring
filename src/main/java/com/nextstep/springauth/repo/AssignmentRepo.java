package com.nextstep.springauth.repo;

import com.nextstep.springauth.model.AssignmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<AssignmentModel,Integer> {
}

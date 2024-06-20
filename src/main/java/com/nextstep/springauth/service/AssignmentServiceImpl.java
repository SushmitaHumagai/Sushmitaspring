package com.nextstep.springauth.service;

import com.nextstep.springauth.model.AssignmentModel;
import com.nextstep.springauth.repo.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepo assignmentRepo;
    @Override
    public void addAssignment(AssignmentModel assignmentModel) {
assignmentRepo.save(assignmentModel);
    }

    @Override
    public void deleteById(int id) {
     assignmentRepo.deleteById(id);
    }

    @Override
    public List<AssignmentModel> getAssignment() {
        List<AssignmentModel>listOfAssignment=assignmentRepo.findAll();
        return listOfAssignment.isEmpty()?new ArrayList<>():listOfAssignment;
    }

    @Override
    public AssignmentModel getAssignmentModel(int id) {
        Optional<AssignmentModel> getAssignment=assignmentRepo.findById(id);
        return getAssignment.orElse(null);
    }

    @Override
    public void editGivenAssignment(AssignmentModel assignmentModel) {
        Optional<AssignmentModel> assignmentModel1=assignmentRepo.findById(assignmentModel.getAssignment_id());
        if(assignmentModel1.isPresent()){
           AssignmentModel assignmentModel2=assignmentModel1.get();
           assignmentModel2.setAssignment_date(assignmentModel.getAssignment_date());
           assignmentModel2.setAssignment_title(assignmentModel.getAssignment_title());
           assignmentModel2.setImage_url(assignmentModel.getImage_url());
           assignmentModel2.setSemester(assignmentModel.getSemester());
           assignmentModel.setSubject(assignmentModel.getSubject());
           assignmentRepo.save(assignmentModel2);
        }

    }
}

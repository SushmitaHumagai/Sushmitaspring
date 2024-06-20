package com.nextstep.springauth.service;

import com.nextstep.springauth.model.AssignmentModel;

import java.util.List;

public interface AssignmentService {
    public void addAssignment(AssignmentModel assignmentModel);
    public void deleteById(int id);
    public List<AssignmentModel>getAssignment();
    public AssignmentModel getAssignmentModel(int id);
    public void editGivenAssignment(AssignmentModel assignmentModel);
}

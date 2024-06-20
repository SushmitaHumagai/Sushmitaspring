package com.nextstep.springauth.controller;

import com.nextstep.springauth.model.AssignmentModel;
import com.nextstep.springauth.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @PreAuthorize("hasAuthority('Teacher')")
    @PostMapping("/saveAssignment")
    public ResponseEntity<String>saveAssignment(@Valid @RequestBody AssignmentModel assignmentModel){
        assignmentService.addAssignment(assignmentModel);
    return new ResponseEntity<>("Assignment successfully saved", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')|| hasAuthority('Student')")
    @GetMapping("/getAssignment")
    public ResponseEntity<List<AssignmentModel>>getAssignment(){
    List<AssignmentModel>assignmentModelList=assignmentService.getAssignment();
    return new ResponseEntity<>(assignmentModelList,HttpStatus.OK);
    }

    @PreAuthorize(("hasAuthority('Teacher')"))
    @DeleteMapping("/delete/{assignment_id}")
    public ResponseEntity<String>delete(@PathVariable("assignment_id") int id){
    assignmentService.deleteById(id);
    return  new ResponseEntity<>("successfully Deleted",HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')")
    @GetMapping("/getAssignmentObject/{assignment_id}")
    public ResponseEntity<AssignmentModel>getAssignmentobject(@PathVariable("assignment_id") int id){
        AssignmentModel assignmentModel=assignmentService.getAssignmentModel(id);
        return new ResponseEntity<>(assignmentModel!=null?assignmentModel:null,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')")
    @PutMapping("/editAssignment")
    public  ResponseEntity<String>editAssignment(@Valid @RequestBody AssignmentModel assignmentModel ){
    assignmentService.editGivenAssignment(assignmentModel);
    return new ResponseEntity<>("Successfully edited",HttpStatus.OK);
    }
}

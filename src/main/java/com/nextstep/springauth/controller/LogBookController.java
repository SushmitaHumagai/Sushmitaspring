package com.nextstep.springauth.controller;

import com.nextstep.springauth.model.LogBookModel;
import com.nextstep.springauth.service.LogService;
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
public class LogBookController {

    @Autowired
    LogService logService;


    @PreAuthorize("hasAuthority('Teacher')")
    @PostMapping("/saveLogBook")
    public ResponseEntity<String>saveLogBook(@Valid @RequestBody LogBookModel logBookModel){
     logService.saveLogBook(logBookModel);
     return new ResponseEntity<>("Successfully logBook Details Saved", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')")
    @GetMapping("/getLogBook")
    public ResponseEntity<List<LogBookModel>>getLogDetail(){
        List<LogBookModel>listOfLogBook=logService.getLogDetail();
        return new ResponseEntity<>(listOfLogBook,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')")
    @DeleteMapping("/deleteLog/{lb_id}")
    public ResponseEntity<String>deleteLog(@PathVariable("lb_id") int id){
        logService.deleteById(id);
        return new ResponseEntity<>("Successfully logbook deleted",HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('Teacher')")
    @GetMapping("/getLogById/{lb_id}")
    public ResponseEntity<LogBookModel>getLogObject(@PathVariable("lb_id") int id){
        LogBookModel logBookModel=logService.getLogDetailObject(id);
        return new ResponseEntity<>(logBookModel!=null?logBookModel:null,HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('Teacher')")
    @PatchMapping("/editLogBook")
    public ResponseEntity<String>editLogBook(@Valid @RequestBody LogBookModel logBookModel){
   logService.editLogDetail(logBookModel);
   return new ResponseEntity<>("Successfully edited",HttpStatus.OK);
    }
}

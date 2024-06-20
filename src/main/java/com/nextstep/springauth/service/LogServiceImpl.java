package com.nextstep.springauth.service;

import com.nextstep.springauth.model.LogBookModel;
import com.nextstep.springauth.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogRepo logRepo;

    @Override
    public void saveLogBook(LogBookModel logBookModel) {
        logRepo.save(logBookModel);
    }

    @Override
    public void deleteById(int id) {
        logRepo.deleteById(id);
    }

    @Override
    public List<LogBookModel> getLogDetail() {

        List<LogBookModel>listOfLogBook=logRepo.findAll();
        return listOfLogBook.isEmpty()?new ArrayList<>():listOfLogBook;
    }

    @Override
    public LogBookModel getLogDetailObject(int id) {
        Optional<LogBookModel> listOfLogObject=logRepo.findById(id);
        return listOfLogObject.orElse(null);
    }

    @Override
    public void editLogDetail(LogBookModel logBookModel) {
Optional<LogBookModel> logBookModel1=logRepo.findById(logBookModel.getLb_id());

if(logBookModel1.isPresent()){
    LogBookModel logBookModel2=logBookModel1.get();
    logBookModel2.setNumber_of_present_students(logBookModel.getNumber_of_present_students());
    logBookModel2.setRemarks(logBookModel.getRemarks());
    logBookModel2.setTeaching_activities(logBookModel.getTeaching_activities());
    logBookModel2.setTeaching_material(logBookModel.getTeaching_material());
    logBookModel2.setTopic(logBookModel.getTopic());
    logBookModel2.setUnit_number(logBookModel.getUnit_number());
    logRepo.save(logBookModel2);
}
    }
}

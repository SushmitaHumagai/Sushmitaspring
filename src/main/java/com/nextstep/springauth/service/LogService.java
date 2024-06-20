package com.nextstep.springauth.service;

import com.nextstep.springauth.model.LogBookModel;

import java.util.List;

public interface LogService {
    public void saveLogBook(LogBookModel logBookModel);
    public void deleteById(int id);
    public List<LogBookModel>getLogDetail();
    public LogBookModel getLogDetailObject(int id);
    public void editLogDetail(LogBookModel logBookModel);
}

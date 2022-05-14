package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.WorkLog;

import java.util.List;

public interface WorkLogService  {

    List<WorkLog> getAllWorks(String username);
    void addWork(WorkLog workLog);
    String  removeWork(Long id );

}

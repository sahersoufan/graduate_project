package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.ActivityWork;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Model.WorkLog;

import java.util.List;

public interface WorkLogService  {

    List<WorkLog> getAllWorks(Long id);
    WorkLog addWork(WorkLog workLog);
    WorkLog getWork(Long id);
    void   delete(WorkLog workLog );
    void update(WorkLog workLog);
     void saveActivity(ActivityWork activityWork);
     List<ActivityWork>getActivity(User user);
    List<ActivityWork> getactivitybyidwork(Long id);
     void deleteactivity(ActivityWork activityWork);

}

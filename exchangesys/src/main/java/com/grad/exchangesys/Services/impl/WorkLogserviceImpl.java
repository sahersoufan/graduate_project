package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.ActivityWork;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Model.WorkImage;
import com.grad.exchangesys.Model.WorkLog;
import com.grad.exchangesys.Repository.ActivityWorkRepo;
import com.grad.exchangesys.Repository.UserRepo;
import com.grad.exchangesys.Repository.WorkLogRepo;
import com.grad.exchangesys.Services.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkLogserviceImpl implements WorkLogService {

    private final WorkLogRepo workLogRepo;
    private final ActivityWorkRepo activityWorkRepo;

    @Override
    public List<WorkLog> getAllWorks(Long id){
       return workLogRepo.getAllByUser(id);
    }

    @Override
    public WorkLog addWork(WorkLog workLog) {
     return   workLogRepo.save(workLog);
    }

    @Override
    public WorkLog getWork(Long id) {
        return workLogRepo.getById(id);
    }

    @Override
    public void delete(WorkLog workLog) { workLogRepo.delete(workLog); }

    @Override
    public void update(WorkLog workLog) { workLogRepo.save(workLog); }

    @Override
    public void saveActivity(ActivityWork activityWork) {
        activityWorkRepo.save(activityWork);

    }

    @Override
    public List<ActivityWork> getActivity(User user) {
        return activityWorkRepo.findTop3ByUserOrderByIdDesc(user);
    }

    @Override
    public List<ActivityWork> getactivitybyidwork(Long id) {
        return activityWorkRepo.findById_work(id);
    }


    @Override
    public void deleteactivity(ActivityWork activityWork) {
        activityWorkRepo.delete(activityWork);
    }
}
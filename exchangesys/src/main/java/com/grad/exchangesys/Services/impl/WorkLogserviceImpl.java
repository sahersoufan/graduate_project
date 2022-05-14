package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Model.WorkLog;
import com.grad.exchangesys.Repository.UserRepo;
import com.grad.exchangesys.Repository.WorkLogRepo;
import com.grad.exchangesys.Services.WorkLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkLogserviceImpl implements WorkLogService {

    private final WorkLogRepo workLogRepo;
    private final UserRepo userRepo;

    @Override
    public List<WorkLog> getAllWorks(String username) {
        User myuser = userRepo.findByUsername(username);

        List<WorkLog> userworks = workLogRepo.findAll();
        List<WorkLog> myworks = new ArrayList<>();

        for (int i = 0; i < workLogRepo.findAll().size(); i++) {
            if (userworks.get(i).getName().equals(username)) {
//                    System.out.println("  name             :  "+friends.get(i).getName());
//                    System.out.println("  friend  id       :  "+friends.get(i).getId_friend());
                myworks.add(userworks.get(i));
            }
        }
        return myworks;
    }

    @Override
    public void addWork(WorkLog workLog) {
        workLogRepo.save(workLog);
    }

    @Override
    public String removeWork(Long id) {

//        WorkLog mywork= workLogRepo.getById(id_work);
//        User user = userRepo.getById(id);
//        if(workLogRepo.getById(id)!=null)
        workLogRepo.delete(workLogRepo.getById(id));
        return "the work was removed ";
    }
}
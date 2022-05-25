package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.WorkImage;
import com.grad.exchangesys.Repository.WorkImageRepo;
import com.grad.exchangesys.Repository.WorkLogRepo;
import com.grad.exchangesys.Services.WorkImageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkImageServicesImpl implements WorkImageServices {

    private final WorkImageRepo workImageRepo;
    @Override
    public void SaveImage(WorkImage workImage) {
        workImageRepo.save(workImage);


    }

    @Override
    public List<WorkImage> getworkimage(Long id) {
        return workImageRepo.getallimagebywork(id);
    }

    @Override
    public void delete(WorkImage workImage) {
        workImageRepo.delete(workImage);
    }
}

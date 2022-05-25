package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.ServicesImage;
import com.grad.exchangesys.Repository.ServicesImgeRepo;
import com.grad.exchangesys.Repository.WorkImageRepo;
import com.grad.exchangesys.Services.ServicesImageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesImageServicesImpl implements ServicesImageServices {
    private final ServicesImgeRepo servicesImgeRepo;
    @Override
    public void SaveImage(ServicesImage servicesImage) {
        servicesImgeRepo.save(servicesImage);

    }

    @Override
    public List<ServicesImage> getservicesimage(Long id) {
        return servicesImgeRepo.getallimagebyservices(id);
    }

    @Override
    public void delete(ServicesImage servicesImage) {
        servicesImgeRepo.delete(servicesImage);

    }
}

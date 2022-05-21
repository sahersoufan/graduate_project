package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.ServicesImage;
import com.grad.exchangesys.Model.WorkImage;

import java.util.List;

public interface ServicesImageServices {
    void SaveImage(ServicesImage servicesImage);
    List<ServicesImage> getservicesimage(Long id);
    void delete(ServicesImage servicesImage);
}

package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.WorkImage;

import java.util.List;

public interface WorkImageServices {
    void SaveImage(WorkImage workImage);
    List<WorkImage> getworkimage(Long id);
    void delete(WorkImage workImage);
}

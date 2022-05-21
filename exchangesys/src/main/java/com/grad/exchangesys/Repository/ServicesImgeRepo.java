package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ServicesImage;
import com.grad.exchangesys.Model.WorkImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicesImgeRepo extends JpaRepository<ServicesImage,Long> {
    @Query("SELECT s  FROM ServicesImage s WHERE  s.serviceModel.id=:id " )
    List<ServicesImage> getallimagebyservices(Long id);
}

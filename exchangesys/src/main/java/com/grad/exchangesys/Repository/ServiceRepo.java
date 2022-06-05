package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepo extends JpaRepository<ServiceModel, Long>{

    List<ServiceModel> findAllByUser(User user);

    @Query("SELECT s  FROM ServiceModel s " +
            " where s.user.id <>:id ORDER BY s.id desc  ")
    List<ServiceModel> services(Long id);

}

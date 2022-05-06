package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepo extends JpaRepository<ServiceModel, Long>{

    List<ServiceModel> findAllByUser(User user);
}

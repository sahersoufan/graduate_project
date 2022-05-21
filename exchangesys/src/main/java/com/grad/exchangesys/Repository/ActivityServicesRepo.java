package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ActivityServices;
import com.grad.exchangesys.Model.ActivityWork;
import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityServicesRepo extends JpaRepository<ActivityServices,Long> {
    List<ActivityServices> findTop3ByUserOrderByIdDesc(User user);
    //List<ActivityServices> findTopByUser;
}

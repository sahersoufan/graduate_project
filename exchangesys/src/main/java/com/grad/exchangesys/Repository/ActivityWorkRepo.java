package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ActivityWork;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityWorkRepo extends JpaRepository<ActivityWork,Long> {


    List<ActivityWork> findTop3ByUserOrderByIdDesc(User user);
    @Query("SELECT w  FROM ActivityWork w WHERE w.id_work=:id " )
    List<ActivityWork> findById_work(Long id);
}

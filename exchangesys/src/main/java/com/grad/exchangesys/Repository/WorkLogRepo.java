package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkLogRepo extends JpaRepository<WorkLog,Long> {

    @Query("SELECT w  FROM WorkLog w WHERE w.user.id =:id " )
    List<WorkLog> getAllByUser(Long id);

}
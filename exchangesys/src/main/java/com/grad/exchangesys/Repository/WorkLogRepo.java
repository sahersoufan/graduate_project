package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkLogRepo extends JpaRepository<WorkLog,Long> {
//    WorkLog findByusername(String email);

}
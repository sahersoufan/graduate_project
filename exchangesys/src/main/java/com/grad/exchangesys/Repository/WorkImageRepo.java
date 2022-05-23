package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.WorkImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkImageRepo  extends JpaRepository<WorkImage,Long> {
    @Query("SELECT w  FROM WorkImage w WHERE w.workLog.id =:id " )
    List<WorkImage>getallimagebywork(Long id);
}

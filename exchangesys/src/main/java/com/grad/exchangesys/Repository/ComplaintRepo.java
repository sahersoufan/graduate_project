package com.grad.exchangesys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grad.exchangesys.Model.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long>{

}

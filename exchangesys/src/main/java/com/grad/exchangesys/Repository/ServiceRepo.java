package com.grad.exchangesys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grad.exchangesys.Model.Service;

public interface ServiceRepo extends JpaRepository<Service, Long>{
	
	
}

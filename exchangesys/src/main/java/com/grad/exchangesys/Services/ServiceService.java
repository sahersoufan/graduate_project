package com.grad.exchangesys.Services;

import java.util.List;

import com.grad.exchangesys.Model.Service;

public interface ServiceService {

	Service saveService(Service service);
	List<Service> getAllServices();
	Service getServiceById(Long id);
	Service updateService(Service service, Long id);
	void deleteService(Long id);

	
	
}

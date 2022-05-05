package com.grad.exchangesys.Services;

import java.util.List;

import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;

public interface ServiceService {

	ServiceModel saveService(ServiceModel serviceModel);
	List<ServiceModel> getAllServices(User user);
	ServiceModel getServiceById(Long id);
	ServiceModel updateService(ServiceModel serviceModel);
	void deleteService(Long id);

	
	
}

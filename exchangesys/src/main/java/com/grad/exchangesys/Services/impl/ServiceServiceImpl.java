package com.grad.exchangesys.Services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.grad.exchangesys.Repository.ServiceRepo;
import com.grad.exchangesys.Services.ServiceService;
import com.grad.exchangesys.exception.ResourceNotFoundException;



@Service
public class ServiceServiceImpl implements ServiceService{

	private ServiceRepo serviceRepo;
	
	public ServiceServiceImpl(ServiceRepo serviceRepo) {
		super();
		this.serviceRepo = serviceRepo;
	}


	@Override
	public com.grad.exchangesys.Model.Service saveService(com.grad.exchangesys.Model.Service service) {

		return serviceRepo.save(service);
	}


	@Override
	public List<com.grad.exchangesys.Model.Service> getAllServices() {
		// TODO Auto-generated method stub
		return serviceRepo.findAll();
	}


	@Override
	public com.grad.exchangesys.Model.Service getServiceById(Long id) {
		
		return serviceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service", "ID", id));
	}


	@Override
	public com.grad.exchangesys.Model.Service updateService(com.grad.exchangesys.Model.Service service, Long id) {
		
		com.grad.exchangesys.Model.Service exisitingService = serviceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service", "ID", id));
		
		exisitingService.setServiceName(service.getServiceName());
		exisitingService.setDescription(service.getDescription());
		
		serviceRepo.save(exisitingService);
		return exisitingService;
		
	}


	@Override
	public void deleteService(Long id) {
		
		serviceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Service", "ID", id));
		
		serviceRepo.deleteById(id);
	
	}
	
	
	
	

	
}

package com.grad.exchangesys.Services.impl;

import java.util.List;

import com.grad.exchangesys.Model.ActivityServices;
import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Repository.ActivityServicesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.grad.exchangesys.Repository.ServiceRepo;
import com.grad.exchangesys.Services.ServiceService;
import com.grad.exchangesys.exception.ResourceNotFoundException;

import javax.transaction.Transactional;


@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class ServiceServiceImpl implements ServiceService{

	private final ServiceRepo serviceRepo;
	private final ActivityServicesRepo activityServicesRepo;



	@Override
	public ServiceModel saveService(ServiceModel serviceModel) {
		ServiceModel serviceModel1=serviceRepo.save(serviceModel);
		if(serviceModel1.getId()==null){
			log.info("erorre in save services");
		}

		return serviceModel1;
	}


	@Override
	public List<ServiceModel> getAllServices(User user) {
		List<ServiceModel> list=serviceRepo.findAllByUser(user);

		return list;
	}


	@Override
	public ServiceModel getServiceById(Long id) {

	 ServiceModel serviceModel=serviceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Service", "ID", id));
		return serviceModel;
	}


	@Override
	public ServiceModel updateService(ServiceModel serviceModel) {
		
		ServiceModel exisitingServiceModel = serviceRepo.findById(serviceModel.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Service", "ID", serviceModel.getId()));
		
		exisitingServiceModel.setServiceName(serviceModel.getServiceName());
		exisitingServiceModel.setDescription(serviceModel.getDescription());
		
		serviceRepo.save(exisitingServiceModel);
		return exisitingServiceModel;
		
	}


	@Override
	public void deleteService(Long id) {
		
		serviceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Service", "ID", id));
		
		serviceRepo.deleteById(id);
	
	}

	@Override
	public List<ActivityServices> getActivate(User user) {
		return activityServicesRepo.findTop3ByUserOrderByIdDesc(user);
	}

	@Override
	public ActivityServices saveactivity(ActivityServices activityServices) {
		return activityServicesRepo.save(activityServices);
	}

	@Override
	public void deleteactivity(String name) {
		ActivityServices activityServices=new ActivityServices();

		activityServicesRepo.delete(activityServices);
	}


}

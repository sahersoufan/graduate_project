package com.grad.exchangesys.Controller;

import java.net.URI;
import java.util.List;

import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grad.exchangesys.Services.ServiceService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/services")
public class ServiceController {

	private final ServiceService serviceService;
	private final UserService userService;

	@PostMapping("/save")
	public Boolean saveService(@RequestBody ServiceModel[] serviceModel, HttpServletRequest request){
		User user=userService.getUser(request);

		for (int i = 0; i< serviceModel.length; i++) {
			ServiceModel serviceModel1 =new ServiceModel();
			serviceModel1.setUser(user);
			serviceModel1.setDescription(serviceModel[i].getDescription());
			serviceModel1.setServiceName(serviceModel[i].getServiceName());
			serviceService.saveService(serviceModel1);
		//	serviceService.saveService(service[i]);

		}
		return true;
	}
	
	@GetMapping("/all")
	public List<ServiceModel> getAllServices(HttpServletRequest request){
		User user=userService.getUser(request);
		return serviceService.getAllServices(user);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ServiceModel> getServiceById(@PathVariable("id") Long serviceId){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/services/"+serviceId).toUriString());
		ServiceModel serviceModel=serviceService.getServiceById(serviceId);
		return ResponseEntity.created(uri).body(serviceModel);

		
	}
	
	@PutMapping("/update")
	public boolean updateService( @RequestBody ServiceModel serviceModel){
		serviceService.updateService(serviceModel);

		return true;
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id){
		
		serviceService.deleteService(id);
		
		return new ResponseEntity<String>("Service Deleted Successfully!.", HttpStatus.OK);
		
	}
	
}

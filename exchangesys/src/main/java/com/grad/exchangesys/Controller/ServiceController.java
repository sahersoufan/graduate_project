package com.grad.exchangesys.Controller;

import java.util.List;

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

import com.grad.exchangesys.Model.Service;
import com.grad.exchangesys.Services.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

	private ServiceService serviceService;

	public ServiceController(ServiceService serviceService) {
		super();
		this.serviceService = serviceService;
	}
	
	@PostMapping
	public ResponseEntity<Service> saveService(@RequestBody Service service){
		return new ResponseEntity<Service>(serviceService.saveService(service), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Service> getAllServices(){
		return serviceService.getAllServices();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Service> getServiceById(@PathVariable("id") Long serviceId){
		
		return new ResponseEntity<Service>(serviceService.getServiceById(serviceId), HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Service> updateService(@PathVariable("id") Long id, @RequestBody Service service){
		
		return new ResponseEntity<Service>(serviceService.updateService(service, id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id){
		
		serviceService.deleteService(id);
		
		return new ResponseEntity<String>("Service Deleted Successfully!.", HttpStatus.OK);
		
	}
	
}

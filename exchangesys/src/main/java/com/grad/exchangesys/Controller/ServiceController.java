package com.grad.exchangesys.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.grad.exchangesys.Model.*;
import com.grad.exchangesys.Services.ServicesImageServices;
import com.grad.exchangesys.Services.UserService;
import com.grad.exchangesys.Services.WorkImageServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.grad.exchangesys.Services.ServiceService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/services")
public class ServiceController {

	private final ServiceService serviceService;
	private final UserService userService;
	private final ServicesImageServices servicesImageServices;


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
	@PostMapping("/add")
	public Long add(@RequestBody ServiceModel serviceModel, HttpServletRequest request){
		User user=userService.getUser(request);



		if(serviceModel.getDescription()==null || serviceModel.getDescription().equals("") ||serviceModel.getServiceName()==null ||serviceModel.getServiceName().equals("")){
			return Long.valueOf(0);
		}
			ServiceModel serviceModel1 =new ServiceModel();
			serviceModel1.setUser(user);
			serviceModel1.setDescription(serviceModel.getDescription());
			serviceModel1.setServiceName(serviceModel.getServiceName());
			ServiceModel service=serviceService.saveService(serviceModel1);
			ActivityServices activityServices=new ActivityServices();
			activityServices.setName("add");
			activityServices.setServicesname(service.getServiceName());
			activityServices.setUser(user);

			serviceService.saveactivity(activityServices);
			//	serviceService.saveService(service[i]);

		return service.getId();
	}

	@GetMapping("/all")
	public List<Object> getAllServices(HttpServletRequest request){
		User user=userService.getUser(request);
		List<Object> list=new ArrayList<>();
		List<ServiceModel> serviceModels=serviceService.getAllServices(user);
		list.add(serviceModels);
		for (ServiceModel serviceModel : serviceModels) {
			list.add(servicesImageServices.getservicesimage(serviceModel.getId()));

		}

		return list;
	}
	@GetMapping("/allhomepage")
	public List<Object> getServiceshomepage(HttpServletRequest request){
		User user=userService.getUser(request);
		List<Object> list=new ArrayList<>();
		List<ServiceModel> serviceModels=serviceService.getServiceshomepage(user);
		List<ServiceModel> serviceModelshome=new ArrayList<>();
		Random rand = new Random();
		for (int i=0;i<10;i++) {
		ServiceModel serviceModel=	serviceModels.get(rand.nextInt(serviceModels.size()));

		if(!serviceModelshome.contains(serviceModel))
		serviceModelshome.add(serviceModel);

		}


		list.add(serviceModels);
		for (ServiceModel serviceModel : serviceModelshome) {
			list.add(servicesImageServices.getservicesimage(serviceModel.getId()));

		}

		return list;
	}
	@GetMapping("/all/{id}")
	public List<Object> servicesfriend(@PathVariable Long id){
		User user=userService.getUser(id);
		List<Object> list=new ArrayList<>();
		List<ServiceModel> serviceModels=serviceService.getAllServices(user);
		list.add(serviceModels);
		for (ServiceModel serviceModel : serviceModels) {
			list.add(servicesImageServices.getservicesimage(serviceModel.getId()));

		}

		return list;
	}
	@GetMapping(value = "/allimage/{id}")
	public List<ServicesImage> getimage(@PathVariable Long id) {

		return servicesImageServices.getservicesimage(id);

	}
	
	@GetMapping("{id}")
	public ResponseEntity<ServiceModel> getServiceById(@PathVariable("id") Long serviceId){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/services/"+serviceId).toUriString());
		ServiceModel serviceModel=serviceService.getServiceById(serviceId);
		return ResponseEntity.created(uri).body(serviceModel);
		
	}
	@PostMapping(value = "/addimage/{id}")
	public Boolean addimageservices(HttpServletRequest request, @RequestParam("files") MultipartFile[] multipartFile, @PathVariable Long id) throws IOException {

		for(int i=0;i<multipartFile.length;i++){

			ServicesImage servicesImage=new ServicesImage();
			String fileName = StringUtils.cleanPath(multipartFile[i].getOriginalFilename());
			User user=userService.getUser(request);
			String uploadDir = "user-photos/services/" + user.getId();
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			Path filePath;
			try (InputStream inputStream = multipartFile[i].getInputStream()) {

				filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				servicesImage.setImagePath(filePath.toString());
				servicesImage.setServiceModel(serviceService.getServiceById(id));

				servicesImageServices.SaveImage(servicesImage);
			} catch (IOException ioe) {
				throw new IOException("Could not save image file: " + fileName, ioe);
			}

		}

		return true;
	}


	@PostMapping(value = "/updateimage/{id}")
	public Boolean updateimagework(HttpServletRequest request,@RequestParam("files")MultipartFile[] multipartFile,@PathVariable Long id) throws IOException {


		List<ServicesImage> servicesImages= servicesImageServices.getservicesimage(id);
		for (int i=0;i<servicesImages.size();i++){
			servicesImageServices.delete(servicesImages.get(i));

		}
		for(int i=0;i<multipartFile.length;i++){

			ServicesImage servicesImage=new ServicesImage();
			String fileName = StringUtils.cleanPath(multipartFile[i].getOriginalFilename());
			User user=userService.getUser(request);
			String uploadDir = "user-photos/services/" + user.getId();
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			Path filePath;
			try (InputStream inputStream = multipartFile[i].getInputStream()) {

				filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				servicesImage.setImagePath(filePath.toString());
				servicesImage.setServiceModel(serviceService.getServiceById(id));

				servicesImageServices.SaveImage(servicesImage);
			} catch (IOException ioe) {
				throw new IOException("Could not save image file: " + fileName, ioe);
			}

		}

		return true;
	}


	@PutMapping("/update")
	public boolean updateService( @RequestBody ServiceModel serviceModel,HttpServletRequest request){
		User user=userService.getUser(request);

		ServiceModel serviceModel1=serviceService.updateService(serviceModel);
		ActivityServices activityServices=new ActivityServices();
		activityServices.setName("edit");
		activityServices.setServicesname(serviceModel1.getServiceName());
		activityServices.setUser(user);
		serviceService.saveactivity(activityServices);
		return true;
		
	}
	

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id){
		serviceService.deleteactivity(serviceService.getServiceById(id).getServiceName());

		List<ServicesImage> servicesImages= servicesImageServices.getservicesimage(id);
		for (ServicesImage imagess : servicesImages) {
			servicesImageServices.delete(imagess);

		}
		serviceService.deleteService(id);

		return new ResponseEntity<String>("Service Deleted Successfully!.", HttpStatus.OK);
		
	}

	@GetMapping("/activity")
	public List<ActivityServices> getactivity(HttpServletRequest request){
		User user=userService.getUser(request);
		return serviceService.getActivate(user);
	}
	
}

package com.grad.exchangesys.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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

import com.grad.exchangesys.Model.Complaint;
import com.grad.exchangesys.Services.ComplaintService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/complaints")
public class ComplaintController {

	private final ComplaintService complaintService;
	private final UserService userService;



	@PostMapping("/save")
	public Boolean saveComplaint(@RequestBody Complaint complaint, HttpServletRequest request){

		User user=userService.getUser(request);


		complaint.setUser(user);
		complaintService.saveComlplaint(complaint);
		return true;
			}
	
	@GetMapping("all")
	public List<Complaint> getAllComplaints(){
		return complaintService.getAllComplaints();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Complaint> getComplaintById(@PathVariable("id") Long complaintId){
		
		return new ResponseEntity<Complaint>(complaintService.getComplaintById(complaintId), HttpStatus.OK);
		
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComplaint(@PathVariable Long id){
		
		complaintService.deleteComplaint(id);
		
		return new ResponseEntity<String>("Complaint Deleted Successfully!.", HttpStatus.OK);
		
	}
	
}

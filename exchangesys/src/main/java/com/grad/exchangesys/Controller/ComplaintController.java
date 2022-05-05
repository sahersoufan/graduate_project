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

import com.grad.exchangesys.Model.Complaint;
import com.grad.exchangesys.Services.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

	private ComplaintService complaintService;

	public ComplaintController(ComplaintService complaintService) {
		super();
		this.complaintService = complaintService;
	}
	
	@PostMapping
	public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint complaint){
		return new ResponseEntity<Complaint>(complaintService.saveComlplaint(complaint), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Complaint> getAllComplaints(){
		return complaintService.getAllComplaints();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Complaint> getComplaintById(@PathVariable("id") Long complaintId){
		
		return new ResponseEntity<Complaint>(complaintService.getComplaintById(complaintId), HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Complaint> updateComplaint(@PathVariable("id") Long id, @RequestBody Complaint complaint){
		
		return new ResponseEntity<Complaint>(complaintService.updateComplaint(complaint, id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComplaint(@PathVariable Long id){
		
		complaintService.deleteComplaint(id);
		
		return new ResponseEntity<String>("Complaint Deleted Successfully!.", HttpStatus.OK);
		
	}
	
}

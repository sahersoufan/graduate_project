package com.grad.exchangesys.Services.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.grad.exchangesys.Model.Complaint;
import com.grad.exchangesys.Repository.ComplaintRepo;
import com.grad.exchangesys.Services.ComplaintService;
import com.grad.exchangesys.exception.ResourceNotFoundException;

@Service @RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService{

	private final ComplaintRepo complaintRepo;
	


	@Override
	public Complaint saveComlplaint(Complaint complaint) {
		
		return complaintRepo.save(complaint);
	}

	@Override
	public List<Complaint> getAllComplaints() {
		
		return complaintRepo.findAll();
	}

	@Override
	public Complaint getComplaintById(Long id) {
		
		return complaintRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint", "ID", id));
	}

	@Override
	public Complaint updateComplaint(Complaint complaint, Long id) {
			
		Complaint existingComplaint = complaintRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint", "ID", id));
											
		existingComplaint.setDescription(complaint.getDescription());
		
		complaintRepo.save(existingComplaint);
		return existingComplaint;
		
	}

	@Override
	public void deleteComplaint(Long id) {
		
		complaintRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Complaint", "ID", id));
		
		complaintRepo.deleteById(id);
		
	}

}

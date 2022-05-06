package com.grad.exchangesys.Services;

import java.util.List;

import com.grad.exchangesys.Model.Complaint;

public interface ComplaintService {

	Complaint saveComlplaint(Complaint complaint);
	List<Complaint> getAllComplaints();
	Complaint getComplaintById(Long id);
	Complaint updateComplaint(Complaint complaint, Long id);
	void deleteComplaint(Long id);
	
}

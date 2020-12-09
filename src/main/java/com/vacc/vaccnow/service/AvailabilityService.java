package com.vacc.vaccnow.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.vacc.vaccnow.model.Branch;

public interface AvailabilityService {

	List<Branch> getAllBranches();

	Optional<Branch> getAllVaccinePerBranch(Long branchId);

	List<Branch> getVaccinePerBranch();

	List<String> getAvailableTime(Long branchId, LocalDate date);
	
	

}

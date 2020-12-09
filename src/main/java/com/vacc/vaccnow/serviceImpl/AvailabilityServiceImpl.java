package com.vacc.vaccnow.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacc.vaccnow.controller.VccnowConstants;
import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.model.TimeAvailability;
import com.vacc.vaccnow.repository.BranchRepository;
import com.vacc.vaccnow.repository.TimeAvailabilityRepository;
import com.vacc.vaccnow.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	TimeAvailabilityRepository timeAvailabilityRepository;

	@Override
	public List<Branch> getAllBranches() {

		return branchRepository.findAll();
	}

	@Override
	public Optional<Branch> getAllVaccinePerBranch(Long branchId) {
		// TODO Auto-generated method stub
		return branchRepository.findById(branchId);
	}

	@Override
	public List<Branch> getVaccinePerBranch() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}

	@Override
	public List<String> getAvailableTime(Long branchId, LocalDate date) {

		List<TimeAvailability> bookedList = timeAvailabilityRepository.findByBranchIdAndSlotDate(branchId, date);
		List<String> bookedSlots = bookedList.stream().map(TimeAvailability::getSlotTime).collect(Collectors.toList());
		return VccnowConstants.TIME_SLOTS.stream().filter(a -> !bookedSlots.contains(a)).collect(Collectors.toList());
	};

}

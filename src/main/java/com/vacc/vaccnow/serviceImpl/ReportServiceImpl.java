package com.vacc.vaccnow.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.model.TimeAvailability;
import com.vacc.vaccnow.repository.TimeAvailabilityRepository;
import com.vacc.vaccnow.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	TimeAvailabilityRepository timeAvailabilityRepository;
	
	@Override
	public Map<Branch, List<TimeAvailability>> getSlotsByBranches() {
		
		List<TimeAvailability> slotList = timeAvailabilityRepository.findAll();
		
		
		Map<Branch,List<TimeAvailability>> slotPerBranch = slotList.stream().collect(Collectors.groupingBy(TimeAvailability::getBranch));
		
		return slotPerBranch;
	}

	@Override
	public List<TimeAvailability> getVaccinationPerDay(String startDate, String endDate) {
		
		LocalDate sdate = LocalDate.parse(startDate);
		LocalDate edate = LocalDate.parse(endDate);
		
		List<TimeAvailability> slotList = timeAvailabilityRepository.findBySlotDateBetween(sdate,edate);
		
		return slotList;
	}

	@Override
	public List<TimeAvailability> getConfirmedVaccination(String startDate, String endDate) {
		
		LocalDate sdate = LocalDate.parse(startDate);
		LocalDate edate = LocalDate.parse(endDate);
		
		List<TimeAvailability> slotList =timeAvailabilityRepository.findBySlotDateBetweenAndSlotStatus(sdate,edate,"CONFIRMED");
		
		return slotList;
	}

	
	
}

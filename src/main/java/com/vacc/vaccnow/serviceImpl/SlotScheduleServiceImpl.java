package com.vacc.vaccnow.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.model.Patient;
import com.vacc.vaccnow.model.ScheduleRequest;
import com.vacc.vaccnow.model.TimeAvailability;
import com.vacc.vaccnow.repository.BranchRepository;
import com.vacc.vaccnow.repository.PatientRepository;
import com.vacc.vaccnow.repository.TimeAvailabilityRepository;
import com.vacc.vaccnow.service.SlotScheduleService;

@Service
public class SlotScheduleServiceImpl  implements SlotScheduleService{

	@Autowired
	TimeAvailabilityRepository timeAvailabilityRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public void scheduleSlot(ScheduleRequest scheduleRequest) {
		
		Optional<Branch> branch =branchRepository.findById(scheduleRequest.getBranchId());
		Optional<Patient> patient = patientRepository.findById(scheduleRequest.getUserId());
		TimeAvailability timeAvailability = new TimeAvailability();
		timeAvailability.setBookedDate(LocalDate.now());
		timeAvailability.setBranch(branch.get());
		timeAvailability.setPaymentType("PENDING");
		timeAvailability.setSlotStatus("PENDING");
		timeAvailability.setSlotDate(LocalDate.parse(scheduleRequest.getSlotDate()));
		timeAvailability.setSlotTime(scheduleRequest.getSlotTime());
		timeAvailability.setPatient(patient.get() );
		timeAvailabilityRepository.save(timeAvailability );
		
	}

	@Override
	public void setPaymentType(Long slotId, String paymentMode) {
		Optional<TimeAvailability> timeAvailability = timeAvailabilityRepository.findById(slotId);
		TimeAvailability timeAvailabilityObj = timeAvailability.get();
		timeAvailabilityObj.setPaymentType(paymentMode);
		timeAvailabilityRepository.saveAndFlush(timeAvailabilityObj);
	}

	@Override
	public void setEmailConfirm(Long slotId) {
		Optional<TimeAvailability> timeAvailability = timeAvailabilityRepository.findById(slotId);
		TimeAvailability timeAvailabilityObj = timeAvailability.get();
		timeAvailabilityObj.setSlotStatus("CONFIRMED");
		timeAvailabilityRepository.saveAndFlush(timeAvailabilityObj);
		
	}

}

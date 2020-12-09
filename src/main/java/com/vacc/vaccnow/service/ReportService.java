package com.vacc.vaccnow.service;

import java.util.List;
import java.util.Map;

import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.model.TimeAvailability;

public interface ReportService {

	List<TimeAvailability> getVaccinationPerDay(String startDate, String endDate);

	List<TimeAvailability> getConfirmedVaccination(String startDate, String endDate);

	Map<Branch, List<TimeAvailability>> getSlotsByBranches();

}

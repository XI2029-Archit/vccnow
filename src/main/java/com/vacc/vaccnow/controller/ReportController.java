package com.vacc.vaccnow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.model.TimeAvailability;
import com.vacc.vaccnow.service.ReportService;

@RestController
@RequestMapping("/api")
public class ReportController {

	@Autowired
	ReportService reportService;

	// Get a list of all applied vaccination per branch

	@GetMapping(value = "/appliedVaccination")
	public ResponseEntity<Object> appliedVaccination() {

		try {

			Map<Branch, List<TimeAvailability>>  timeAvailabilityMap = reportService.getSlotsByBranches();

			if (timeAvailabilityMap != null && timeAvailabilityMap.size() > 0) {
				return new ResponseEntity<Object>(timeAvailabilityMap, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("No vaccination exists", HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

	// Get a list of all applied vaccination per day/period

	@GetMapping(value = "/vaccinationPerDayOrPeriod")
	public ResponseEntity<Object> vaccinationPerDayOrPeriod(@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		try {

			List<TimeAvailability> timeAvailabilityList = reportService.getVaccinationPerDay(startDate, endDate);

			if (timeAvailabilityList != null && timeAvailabilityList.size() > 0) {
				return new ResponseEntity<Object>(timeAvailabilityList, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("No vaccination exists", HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

   //	Show all confirmed vaccinations over a time period 

	@GetMapping(value = "/confirmedVaccination")
	public ResponseEntity<Object> confirmedVaccination(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		try {

			List<TimeAvailability> timeAvailabilityList = reportService.getConfirmedVaccination(startDate, endDate);

			if (timeAvailabilityList != null && timeAvailabilityList.size() > 0) {
				return new ResponseEntity<Object>(timeAvailabilityList, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("No vaccination exists", HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

}

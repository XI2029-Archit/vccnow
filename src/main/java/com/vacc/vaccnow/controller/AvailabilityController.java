package com.vacc.vaccnow.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vacc.vaccnow.model.Branch;
import com.vacc.vaccnow.service.AvailabilityService;

@RestController
@RequestMapping("/api")
public class AvailabilityController {

	@Autowired
	AvailabilityService availabilityService;

	// Get a list of all branches
	@GetMapping(value = "/branches")
	public ResponseEntity<Object> branches() {

		try {

			List<Branch> branchList = availabilityService.getAllBranches();

			if (branchList != null && branchList.size() > 0) {
				return new ResponseEntity<Object>(branchList, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("No branch exists", HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

	// Get a list of all available vaccines per branch
	@GetMapping(value = "/vaccines/{branchId}")
	public ResponseEntity<Object> allvaccinesPerBranch(@PathVariable("branchId") Long branchId) {

		try {

			Optional<Branch> vaccinesList = availabilityService.getAllVaccinePerBranch(branchId);

			return new ResponseEntity<Object>(vaccinesList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

	
	// Get available time for a branch
		@GetMapping(value = "/vaccines")
		public ResponseEntity<Object> vaccinesPerBranch() {

			try {

				List<Branch> vaccinesList = availabilityService.getVaccinePerBranch();

				return new ResponseEntity<Object>(vaccinesList, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
			}

		}
		
		// Get a specific availability by branch
		@GetMapping(value = "/availableTime/{branchId}")
		public ResponseEntity<Object> availableTime(@PathVariable("branchId") Long branchId, @RequestParam("slotDate") String slotDate) {

			try {

				LocalDate date = LocalDate.parse(slotDate);
				List<String> availableTimeList = availabilityService.getAvailableTime(branchId,date);

				return new ResponseEntity<Object>(availableTimeList, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
			}

		}

}

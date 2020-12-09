package com.vacc.vaccnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vacc.vaccnow.model.ScheduleRequest;
import com.vacc.vaccnow.service.SlotScheduleService;

@RestController
@RequestMapping("/api")
public class VaccinationController {

	@Autowired
	SlotScheduleService slotScheduleService;

	/*
	 * Schedule vaccination timeslot (15 minutes)
	 */

	@PutMapping(value = "/scheduleSlot")
	public ResponseEntity<Object> scheduleSlot(@RequestBody ScheduleRequest scheduleRequest) {

		try {
			
			slotScheduleService.scheduleSlot(scheduleRequest);

			return new ResponseEntity<Object>("Successfully Scheduled", HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}
	
	//Choose Payment Method Cash,Credit, or Fawry 
	
	@PostMapping(value = "/paymentType")
	public ResponseEntity<Object> setPaymentType(@RequestParam("id") Long slotId, @RequestParam("paymentMode") String paymentMode) {

		try {

			slotScheduleService.setPaymentType(slotId,paymentMode);

			return new ResponseEntity<Object>("Successfully updated", HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}	
	
	/* Confirm scheduled vaccination by email */
	
	@PostMapping(value = "/emailConfirm")
	public ResponseEntity<Object> emailConfirm(@RequestParam("id") Long slotId) {

		try {

			slotScheduleService.setEmailConfirm(slotId);

			return new ResponseEntity<Object>("Successfully updated", HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at backend");
		}

	}

}

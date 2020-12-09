package com.vacc.vaccnow.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScheduleRequest {
	
	Long userId;
	String slotTime;
	Long branchId;
	String slotDate;

}

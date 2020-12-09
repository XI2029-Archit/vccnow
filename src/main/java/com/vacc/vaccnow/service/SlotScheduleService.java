package com.vacc.vaccnow.service;

import com.vacc.vaccnow.model.ScheduleRequest;

public interface SlotScheduleService {

	void scheduleSlot(ScheduleRequest scheduleRequest);

	void setPaymentType(Long slotId, String paymentMode);

	void setEmailConfirm(Long slotId);


}

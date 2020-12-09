package com.vacc.vaccnow.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacc.vaccnow.model.TimeAvailability;

@Repository
public interface TimeAvailabilityRepository extends JpaRepository<TimeAvailability,Long> {

	List<TimeAvailability> findByBranchIdAndSlotDate(Long branchId,LocalDate date);

	/*
	 * List<TimeAvailability>
	 * findBySlotDateAfterEqualAndSlotDateBeforeEqual(LocalDate sdate, LocalDate
	 * edate);
	 * 
	 * List<TimeAvailability>
	 * findBySlotDateAfterEqualAndSlotDateBeforeEqualAndSlotStatus(LocalDate sdate,
	 * LocalDate edate, String string);
	 */

	List<TimeAvailability> findBySlotDateBetween(LocalDate sdate, LocalDate edate);

	List<TimeAvailability> findBySlotDateBetweenAndSlotStatus(LocalDate sdate, LocalDate edate, String string);

	
}

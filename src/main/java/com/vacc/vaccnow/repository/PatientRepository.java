package com.vacc.vaccnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacc.vaccnow.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}

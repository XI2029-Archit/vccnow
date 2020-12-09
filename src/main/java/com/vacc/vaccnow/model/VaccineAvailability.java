package com.vacc.vaccnow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VaccineAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@JsonIgnoreProperties("vaccineAvailability")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "vaccines_id")
	@JsonIgnoreProperties("vaccineAvailability")
	private Vaccines vaccines;

	private int totalVaccine;
	private int leftVaccine;

}
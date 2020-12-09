package com.vacc.vaccnow.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vaccines {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vccName;
  
    @OneToMany(mappedBy = "vaccines" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vaccines")
    Set<VaccineAvailability> vaccineAvailability;

}

package com.slokam.healthcare.service;

import java.util.List;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;

public interface IPatientService {
public void PatientRegistration(Patient p);
public List<Patient> getAll();
public List<Patient> criteriaTest(PatientSearchPojo ps);
	
	
}

package com.slokam.healthcare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.repo.IPatientRepo;
import com.slokam.healthcare.repo.PatientCriteria;
import com.slokam.healthcare.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService{
@Autowired
	private IPatientRepo patientrepo;	
@Autowired
private PatientCriteria pc;
	@Override
	public void PatientRegistration(Patient patient) {
		patient.setRegdate(new Date());
		patientrepo.save(patient);
	}

	@Override
	public List<Patient> getAll() {
		
		return patientrepo.findAll();
	}

	@Override
	public List<Patient> criteriaTest(PatientSearchPojo ps) {
      		
		return pc.patientFullSearch(ps);
	}

	
	
}

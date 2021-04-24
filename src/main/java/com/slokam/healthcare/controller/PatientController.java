package com.slokam.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.service.IPatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
@Autowired
	private IPatientService ps;
@PostMapping("/save")
public ResponseEntity<Patient> patientReg(@RequestBody Patient patient) {
	         ps.PatientRegistration(patient);
	      return  new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	
}	
@GetMapping("get")
public ResponseEntity<List<Patient>> getAllDet(){
	
	List<Patient> list=ps.getAll();
	return  new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	
}@GetMapping("getall")
public ResponseEntity<List<Patient>> patientcritiria(@RequestBody PatientSearchPojo psp){

	return  new ResponseEntity<List<Patient>>(ps.criteriaTest(psp),HttpStatus.OK);
	
}


	
	
}

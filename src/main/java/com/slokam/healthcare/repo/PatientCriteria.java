package com.slokam.healthcare.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
import com.slokam.healthcare.util.StringUtils;
@Repository
public class PatientCriteria {
@Autowired
	private	EntityManager em;
	
	public  List<Patient> patientFullSearch(PatientSearchPojo ps){
		CriteriaBuilder cb=em.getCriteriaBuilder();
CriteriaQuery<Patient> cq=cb.createQuery(Patient.class);
          Root<Patient> root=cq.from(Patient.class);
		  List<Predicate> pl=new ArrayList<>();  
		    if(ps!=null) {
		    	if(ps.getPhone()!=null) {
		    		pl.add((Predicate) cb.equal(root.get("phone"),ps.getPhone() ));
		    	}
		    	if(ps.getFromdate()!=null) {
		    		pl.add((Predicate) cb.greaterThanOrEqualTo(root.get("regdate"), ps.getFromdate()));
		    	}
		    	if(ps.getTodate()!=null) {
		    		pl.add((Predicate) cb.lessThanOrEqualTo(root.get("regdate"), ps.getTodate()));
		    	}
		    	if(StringUtils.blankCheck(ps.getName())) {
		    		pl.add((Predicate) cb.equal(root.get("name"), ps.getName()));
		    	}
		    	
		    }
		   
		    cq.where(pl.toArray(new Predicate[pl.size()]));
		    TypedQuery<Patient> pq=em.createQuery(cq);
		return pq.getResultList();
		
	}
}

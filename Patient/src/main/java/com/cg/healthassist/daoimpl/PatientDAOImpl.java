package com.cg.healthassist.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthassist.dao.PatientDAO;
import com.cg.healthassist.model.Patient;
import com.cg.healthassist.util.JPAUtil;

/**
 * Implements all the crud operation of PatientDAO interface and also extends JPAUtil for various transactions.
 * @author Aman Soni
 *
 */
public class PatientDAOImpl extends JPAUtil implements PatientDAO{
	
	@Override
	public void persist(Patient patient) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		em.persist(patient);
		long patientId = patient.getPatientId();
		Patient.setPatientCredentials(patientId, patient.getPatientUserName());
		commitTransaction(em);
		closeEntityManager(em);
	}

	@Override
	public Patient findByPatientId(long patientId) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Patient patient = em.find(Patient.class, patientId);
		commitTransaction(em);
		closeEntityManager(em);
		return patient;
	}

	@Override
	public void removePatient(long patientId) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Patient patientFound = em.find(Patient.class, patientId);
		if(patientFound!=null) {
			em.remove(patientFound);
		}
		commitTransaction(em);
		closeEntityManager(em);
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Query query = em.createQuery("from Patient");
		List<Patient> patientList = query.getResultList();
		commitTransaction(em);
		closeEntityManager(em);
		return patientList;
	}

	@Override
	public boolean update(String prescription, long patientId) {
		boolean updated = false;
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Patient patientToUpdate = em.find(Patient.class,patientId);
		if(patientToUpdate!=null) {
			patientToUpdate.setPrescription(prescription);
			updated = true;
		}
		commitTransaction(em);
		closeEntityManager(em);
		return updated;
	}

}

package com.cg.healthassist.dao;

import com.cg.healthassist.model.Patient;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * An interface to provide declaration of all the CRUD operation of patient.
 * @author Aman Soni
 *
 */
public interface PatientDAO {
	/**
	 * This method will save the data of the patient in database.
	 * @param patient, Instance of patient to persist.
	 */
	public void persist(Patient patient);
	
	/**
	 * Search the patient with given id in the database.
	 * @param id of the patient to search.
	 * @return the instance of patient if present else return null.
	 */
	public Patient findByPatientId(long patientId);
	
	/**
	 * Remove the given instance of patient from the database if present. 
	 * @param patient id to remove.
	 */
	public void removePatient(long patientId);
	
	/**
	 * Give all the instances of patients present inside database.
	 * @return the list of patient instances.
	 */
	public List<Patient> findAll();
	
	/**
	 * Upload the given patient doctor prescription inside the database if present.
	 * @param prescription given by the doctor.
	 * @param id of the patient.
	 * @return true if successfully updated else return false.
	 */
	public boolean update(String prescription,long patientId);
}

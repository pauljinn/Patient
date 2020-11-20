package com.cg.healthassist.util;

import java.util.List;

import com.cg.healthassist.daoimpl.PatientDAOImpl;
import com.cg.healthassist.model.Patient;

/**
 * This is the utility class used to provide the authentication of patient user name and password while sign in and sign up.
 * @author Aman Soni
 *
 */
public class AuthenticationUtil {
	
	/**
	 * Method to validate patient username and password to avoid providing duplicates
	 * @param userName
	 * @param password
	 * @return true if unique details provided
	 */
	public boolean authenticateUserName(String userName) {
		boolean check=false;
		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
		List<Patient> patientDetails = patientDAOImpl.findAll();
		for(Patient patients: patientDetails) {
			if(patients.getPatientUserName().equals(userName)){
				check = true;
				break;
			}
		}
		return check;
		
	}
	/**
	 * Method to check the provided username and password matching with the patient in database or not
	 * @param userName
	 * @param password
	 * @return true if username and password matched
	 */
	public boolean signInValidationOfUserNameAndPassword(String userName, String password) {
		long patientId;
		boolean check=false;
		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
		List<Patient> patientDetails = patientDAOImpl.findAll();
		for(Patient patients: patientDetails) {
			if(patients.getPatientUserName().equalsIgnoreCase(userName) && patients.getPatientPassword().equals(password)) {
				check = true;
				break;
			}
		}
		return check;
	}
}
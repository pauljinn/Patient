package com.cg.healthassist.service;


import java.util.List;

import com.cg.healthassist.exception.PrescriptionException;
import com.cg.healthassist.exception.UserNameException;
import com.cg.healthassist.model.*;

/**
 * Declare all the services requried by the patient from life line application.
 * @author Aman Soni
 *
 */
public interface PatientService {
	/**
	 * Search the doctors with given specialty in doctor database.
	 * @param speciality
	 * @return the list of doctors if present otherwise an empty list.
	 */
	public List<Doctor> searchDoctor(String speciality);
	/**
	 * Book the appointment for patient with a doctor having given specialty.
	 * @param speciality
	 * @return the information about booking.
	 */
	public String bookDoctorAppointment(String speciality);
	
	/**
	 * Search the medical store on given medicine whether it is present or not.
	 * @param medicine
	 * @return the first medical store in database which has that medicine otherwise return null.
	 */
	public MedicalStore searchMedicalStore(String medicineName);
	
	/**
	 * Based on doctor prescription order the medicine for the patient.
	 * @return the list of successfully ordered medicine otherwise return empty list.
	 */
	public List<String> orderMedicine(String patientUserName) throws UserNameException,PrescriptionException;
	
	/**
	 * Upload the prescription given by the doctor to patient.
	 * @param prescription
	 * @return true on successful uploading otherwise return false.
	 */
	public boolean uploadPrescriptionCopy(long patientId,String prescription);

}

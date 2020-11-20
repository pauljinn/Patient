package com.cg.healthassist.service;

import java.util.List;

import com.cg.healthassist.model.Doctor;

/**
 * Declar all the services offered by doctor to patient.
 * @author Aman Soni
 *
 */
public interface DoctorService {
	/**
	 * This method searches doctor based on the speciality specified by the patient
	 * @param speciality
	 * @return 
	 */
	public List<Doctor> searchDoctor(String speciality);
	/**
	 * This method is used to book an appointment with the doctor based on the speciality specified by the patient
	 * @param speciality
	 * @return 
	 */
	public String bookDoctorAppointment(String speciality);


}
package com.cg.healthassist.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	private String patientName;
	private int patientAge;
	private long phoneNumber;
	private String patientAddress;
	private String prescription;
	private String patientUserName;
	private String patientPassword;
	/**
	 * Relate patient id with patient user name.
	 */
	private static Map<Long,String> patientCredentials = new HashMap<>();
	
	/**
	 * Create an instance of patient with given parameters.
	 * @param patientName
	 * @param patientAge
	 * @param phoneNumber
	 * @param patientAddress
	 * @param patientUserName
	 * @param patientPassword
	 */
	public Patient(String patientName, int patientAge, long phoneNumber, String patientAddress, String patientUserName,
			String patientPassword) {
		super();
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.phoneNumber = phoneNumber;
		this.patientAddress = patientAddress;
		this.patientUserName = patientUserName;
		this.patientPassword = patientPassword;
	}
	
	public Patient() {
		super();
	}



	/**
	 * @return the patient id present in the database.
	 */
	public long getPatientId() {
		return patientId;
	}
	
	/**
	 * Set the id of the patient.
	 * @param patientId
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * @return the patient name.
	 */
	public String getPatientName() {
		return patientName;
	}
	
	/**
	 * Set the name of the patient.
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 * @return the age of the patient.
	 */
	public int getPatientAge() {
		return patientAge;
	}
	
	/**
	 * Set the age of the patient.
	 * @param patientAge
	 */
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	/**
	 * @return the phone number of the patient.
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the phone number of the patient.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the address of the patient.
	 */
	public String getPatientAddress() {
		return patientAddress;
	}
	
	/**
	 * set the address of the patient.
	 * @param patientAddress
	 */
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	/**
	 * @return the prescription of the patient.
	 */
	public String getPrescription() {
		return prescription;
	}
	
	/**
	 * Set the prescription of the patient.
	 * @param prescription
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	/**
	 * @return the user name of the patient used while sign in application.
	 */
	public String getPatientUserName() {
		return patientUserName;
	}
	
	/**
	 * Set the user name of the patient.
	 * @param patientUserName
	 */
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	
	/**
	 * @return the password of the patient for authentication purpose.
	 */
	public String getPatientPassword() {
		return patientPassword;
	}
	
	/**
	 * Set the password of the patient when patient sign up in the application.
	 * @param patientPassword
	 */
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	
	/**
	 * @return the map of the credentials i.e patient id and patient user name.
	 */
	public static Map<Long, String> getPatientCredentials() {
		return patientCredentials;
	}
	
	/**
	 * Set the new patient id and patient user name inside the map of patient credentials.
	 * @param patientId
	 * @param patientUserName
	 */
	public static void setPatientCredentials(Long patientId, String patientUserName) {
		Patient.patientCredentials.put(patientId, patientUserName);
	}

	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", patientAge=" + patientAge + ", phoneNumber=" + phoneNumber
				+ ", patientAddress=" + patientAddress + ", prescription=" + prescription + ", patientUserName="
				+ patientUserName + ", patientPassword=" + patientPassword + "]";
	}
	
}

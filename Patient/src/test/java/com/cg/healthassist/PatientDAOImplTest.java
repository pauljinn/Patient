package com.cg.healthassist;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.healthassist.daoimpl.PatientDAOImpl;
import com.cg.healthassist.model.Patient;

public class PatientDAOImplTest {
	/**
	 * Instance of an implemented patient dao.
	 */
	private static PatientDAOImpl patientDao;
	
	
	/**
	 * Run once before running any test cases and create a new instance of patient dao.
	 */
	@BeforeClass
	public static void runOnce() {
		patientDao = new PatientDAOImpl();
	}
	
	/**
	 * Test the persist functionality of patient dao whether it saving the patient inside the database or not.
	 */
	@Test
	public void test_Persist_GivenPatient() {
		Patient patient = new Patient("Chaitanya",21,6382963639L,"Mars","ABC","123");
		patientDao.persist(patient);
		Patient patientFound = patientDao.findByPatientId(patient.getPatientId());
		assertEquals(patient.getPatientUserName(), patientFound.getPatientUserName());
	}
	
	/**
	 * Test the find by id method of patient dao given the id of the patient it checks whether the patient is same as what expected.
	 */
	@Test
	public void test1_findByPatientId_GivenPatientId_ShouldReturnPatient() {
		Patient patientFound = patientDao.findByPatientId(9);
		assertEquals("ABC",patientFound.getPatientUserName());
	}
	
	/**
	 * Test the find by id method of patient dao given the invalid id of the patient it checks whether null is returning or not.
	 */
	@Test
	public void test2_findByPatientId_GivenPatientId_ShouldReturnNull() {
		Patient patientFound = patientDao.findByPatientId(23);
		assertEquals(null,patientFound);
	}
	
	/**
	 * Test the remove method of patient dao by checking whether the patient with correct id is removed from database.
	 */
	@Test
	public void test1_removePatient_GivenPatientId() {
		int oldSize = patientDao.findAll().size();
		patientDao.removePatient(12);
		int newSize = patientDao.findAll().size();
		assertNotEquals(oldSize, newSize);
	}
	
	/**
	 * Test the remove method of patient dao by checking whether the patient with incorrect id is not removed from database.
	 */
	@Test
	public void test2_removePatient_GivenPatientId() {
		int oldSize = patientDao.findAll().size();
		patientDao.removePatient(5);
		int newSize = patientDao.findAll().size();
		assertEquals(oldSize, newSize);
	}
	
	/**
	 * Test whether the list of patients successfully fetched from database or not by checking the size of list not zero.
	 */
	@Test
	public void test_findAll_ShouldReturnListOfPatients() {
		List<Patient> patientList = patientDao.findAll();
		assertNotEquals(0,patientList.size());
	}
	
	/**
	 * Test whether the patient prescription successfully uploaded or not given that patient id is correct.
	 */
	@Test
	public void test_update_TakePatientInstanceAndPrescription_ShouldReturnBoolean() {
		String prescription = "Cipla,Dispiring";
		boolean status = patientDao.update(prescription, 9);
		assertTrue(status);
	}
	
	/**
	 * Testing update for wrong patient id and checking whether the update status is false or not.
	 */
	@Test
	public void test_update_TakePatientInstanceAndPrescription_ShouldReturnFalse() {
		String prescription = "1. Cipla \n 2. Dispiring";
		boolean status = patientDao.update(prescription, 20);
		assertFalse(status);
	}
	
	

}

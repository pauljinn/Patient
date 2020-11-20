package com.cg.healthassist;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.healthassist.daoimpl.DoctorDAOImpl;
import com.cg.healthassist.model.Doctor;

public class DoctorDAOImplTest {
	/*
	 * Instance of an implemented patient dao.
	 */
	private static DoctorDAOImpl dao;
	/**
	 * Run once before running any test cases and create a new instance of patient dao.
	 */
	@BeforeClass
	public static void runOnce()
	{
	  dao = new DoctorDAOImpl();
	}
	
	/**
	 * Test the persist method 
	 */
	@Test
	public void test_Persist_GivenDoctor() 
	{
		Doctor doctor = new Doctor("Sample2","MS","Cardiology",123445789L);
		dao.persist(doctor);
		Doctor doctorFound = dao.findByDoctorId(doctor.getDoctorId());
		assertEquals(doctor.getDoctorId(), doctorFound.getDoctorId());
		
	}
	/**
	 * Test the findByDoctorId method of doctor dao it checks whether the doctor id entered by patient is present in the database 
	 */
		
	@Test	
	public void test1_findByDoctorId_GivenDoctorId_ShouldReturnTheDoctorWithGivenId() 
	{
		Doctor doctorFound = dao.findByDoctorId(2);
		assertEquals("Sample1",doctorFound.getDoctorName());
	}
	/**
	 * Test the findByDoctorId method of doctor dao it checks whether the doctor id entered by patient is present in the database
	 *  and returns null if not present
	 */
	@Test
	public void test2_findDoctorById_GivenDoctorId_ShouldReturnNull()
	{
		Doctor doctorFound = dao.findByDoctorId(9);
		assertEquals(null,doctorFound);
	}
	/**
	 * Test whether the list of doctors successfully fetched from database or not by checking the size of the list
	 */
	@Test 
	public void test_findAll_ShouldReturnListOfDoctors() 
	{
		DoctorDAOImpl dao = new DoctorDAOImpl();
		List<Doctor> doctorList = dao.findAll();
		assertEquals(8,doctorList.size());
		
		
	}
		
}
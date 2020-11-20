package com.cg.healthassist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.healthassist.daoimpl.HospitalDAOImpl;
import com.cg.healthassist.model.Hospital;

public class HospitalDAOImplTest {
	/**
	 * Instance of an implemented hospital dao.
	 */
	private static HospitalDAOImpl hospitalDao;
	
	
	/**
	 * Run once before running any test cases and create a new instance of hospital dao.
	 */
	@BeforeClass
	public static void runOnce() {
		hospitalDao = new HospitalDAOImpl();
	}
	@Test
	public void test_Persist_GivenHospital() {
		HospitalDAOImpl dao = new HospitalDAOImpl();
		Hospital hospital = new Hospital("heart hospital", "mahishmathi", 9456231783L, "heart");
		dao.persist(hospital);
		Hospital hospitalFound = hospitalDao.findByHospitalId(hospital.getHospitalId());
		assertEquals(hospital.getHospitalName(), hospitalFound.getHospitalName());
	}
	/**
	 * Test the find by id method of hospital dao given the id of the patient it checks whether the hospital is same as what expected.
	 */
	@Test
	public void test1_findByHospitalId_GivenHospitalId_ShouldReturnHospital() {
		Hospital hospitalFound = hospitalDao.findByHospitalId(9);
		assertEquals("ABC",hospitalFound.getHospitalName());
	}
	
	/**
	 * Test the find by id method of hospital dao given the invalid id of the patient it checks whether null is returning or not.
	 */
	@Test
	public void test2_findByHospitalId_GivenHospitalId_ShouldReturnNull() {
		Hospital hospitalFound = hospitalDao.findByHospitalId(23);
		assertEquals(null,hospitalFound);
	}
	/**
	 * Test whether the list of hospitals successfully fetched from database or not by checking the size of list not zero.
	 */
	@Test
	public void test_findAll_ShouldReturnListOfHospitals() {
		List<Hospital> hospitalList = hospitalDao.findAll();
		assertNotEquals(0,hospitalList.size());
	}
}
package com.cg.healthassist.dao;

import java.util.List;

import com.cg.healthassist.model.Hospital;

public interface HospitalDAO {
	/**
	 * This method will save data of the hospital in database
	 * @param hospital instance of hospital to persist
	 */
	public void persist(Hospital hospital);
	/**
	 * Give all the instance of hospitals present inside database
	 * @return list of hospital instance
	 */
	public List<Hospital> findAll();
	
	/**
	 * Find the hospital in the database with given id.
	 * @param hospitalId
	 * @return the hospital if present in database otherwise return null.
	 */
	public Hospital findByHospitalId(long hospitalId);

}
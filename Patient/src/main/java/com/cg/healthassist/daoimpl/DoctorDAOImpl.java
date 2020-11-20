package com.cg.healthassist.daoimpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.cg.healthassist.dao.DoctorDAO;
import com.cg.healthassist.model.Doctor;
import com.cg.healthassist.util.JPAUtil;

public class DoctorDAOImpl extends JPAUtil implements DoctorDAO {

	@Override
	public void persist(Doctor doctor) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		System.out.println(doctor);
		em.persist(doctor);
		commitTransaction(em);
		closeEntityManager(em);
		
	}

	@Override
	public List<Doctor> findAll() {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Query query = em.createQuery("from Doctor");
		List<Doctor> doctorList = query.getResultList();
		if(doctorList.size()!=0) {
			return doctorList;
		}
		else {
			return null;
		}
	}

	@Override
	public Doctor findByDoctorId(long doctorId) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Doctor doctor = em.find(Doctor.class, doctorId);
		commitTransaction(em);
		closeEntityManager(em);
		return doctor;
	}

}

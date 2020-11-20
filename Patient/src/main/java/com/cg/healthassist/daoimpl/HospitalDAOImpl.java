package com.cg.healthassist.daoimpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.cg.healthassist.dao.HospitalDAO;
import com.cg.healthassist.model.Hospital;
import com.cg.healthassist.util.JPAUtil;

public class HospitalDAOImpl extends JPAUtil implements HospitalDAO {

	@Override
	public void persist(Hospital hospital) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		em.persist(hospital);
		commitTransaction(em);
		closeEntityManager(em);
	}
	@Override
	public Hospital findByHospitalId(long hospitalId) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Hospital hospital = em.find(Hospital.class, hospitalId);
		commitTransaction(em);
		closeEntityManager(em);
		return hospital;
	}

	@Override
	public List<Hospital> findAll() {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Query query = em.createQuery("from Hospital");
		List<Hospital> hospitalList = query.getResultList();
		return hospitalList;
	}

}
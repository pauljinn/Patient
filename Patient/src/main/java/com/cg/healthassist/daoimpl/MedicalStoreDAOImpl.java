package com.cg.healthassist.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.healthassist.dao.MedicalStoreDAO;
import com.cg.healthassist.model.MedicalStore;
import com.cg.healthassist.util.JPAUtil;

/**
 * Implements all the CRUD operation of MedicalStoreDAO interface and also extends JPAUtil for performing various transactions.
 * @author Aman Soni
 *
 */
public class MedicalStoreDAOImpl extends JPAUtil implements MedicalStoreDAO {

	@Override
	public void persist(MedicalStore medicalStore) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		em.persist(medicalStore);
		commitTransaction(em);
		closeEntityManager(em);
	}

	@Override
	public MedicalStore findByMedicalStoreId(long medicalStoreId) {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		MedicalStore medicalStore = em.find(MedicalStore.class, medicalStoreId);
		commitTransaction(em);
		closeEntityManager(em);
		return medicalStore;
	}

	@Override
	public List<MedicalStore> findAll() {
		EntityManager em = getEntityManager();
		beginTransaction(em);
		Query query = em.createQuery("from MedicalStore");
		List<MedicalStore> medicalStoreList = query.getResultList();
		commitTransaction(em);
		closeEntityManager(em);
		return medicalStoreList;
	}

}

package com.cg.healthassist;

import com.cg.healthassist.daoimpl.MedicalStoreDAOImpl;
import com.cg.healthassist.daoimpl.PatientDAOImpl;
import com.cg.healthassist.exception.PrescriptionException;
import com.cg.healthassist.exception.UserNameException;
import com.cg.healthassist.model.MedicalStore;
import com.cg.healthassist.model.Medicine;
import com.cg.healthassist.model.Patient;
import com.cg.healthassist.service.*;
import com.cg.healthassist.serviceimpl.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger; 
import com.cg.healthassist.util.*;

public class App 
{
	private static Logger logger=Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	/**
    	 * Adding a patient in database.
    	 */
    	logger.info("Creating patient");
    	Patient patient = new Patient("Chaitanya",21,6382963639L,"Mars","ABC","123");
    	logger.info(patient);
    	logger.info("Persisting patient");
    	PatientDAOImpl patientDao = new PatientDAOImpl();
    	logger.info(patientDao);
		patientDao.persist(patient);
		logger.info("Successffully saved inside database");
		
		/**
		 * Creating medicine instanes.
		 */
		logger.info("Creating medicines");
		Medicine m1 = new Medicine("Crocin",120,"Mankind","12/12/2021","23/08/2020");
		logger.info(m1);
		Medicine m2 = new Medicine("Dispirin",80,"Cipla","01/01/2022","15/07/2020");
		logger.info(m2);
		
		/**
		 * Creating a list of medicine using medicine instance created.
		 */
		logger.info("Creating list of medicine");
		List<Medicine> medicineList = new ArrayList<>();
		logger.info(medicineList);
		medicineList.add(m1);
		medicineList.add(m2);
		logger.info("Medicines successfully added in the list");
		
		/**
		 * Creating a medical store.
		 */
		logger.info("Creating medical store");
		MedicalStore medicalStore = new MedicalStore("Avon",9811123456L,"XYZ",medicineList,"Shubham");
		logger.info("Medical Store created");
		MedicalStoreDAOImpl medicalStoreDao = new MedicalStoreDAOImpl();
		logger.info(medicalStoreDao);
		medicalStoreDao.persist(medicalStore);
		logger.info("Successfully persist the medical store");
		
		/**
		 * Checking search medicine service offered to patient by medical store.
		 */
		logger.info("Initializing patient Services");
    	PatientService patientService = new PatientServiceImpl();
    	logger.info(patientService);
    	logger.info("Testing search service in which patient can get medical store having given medicine");
    	MedicalStore medicalStoreFound = patientService.searchMedicalStore("crocin");
    	logger.info("Details of the medical store with crocin available is: " + medicalStoreFound);
    	
    	/**
    	 * Checking the upload prescription copy service offered by medical store.
    	 */
        logger.info("Uploading the prescription copy for patient with id 3 in the patient database");
        boolean status = patientService.uploadPrescriptionCopy(3,"Cipla,Dispirin");
        if(status==true)
        	logger.info("Successfuly uploaded the precription for given patient");
        else
        	logger.info("Uploading precription copy failed as their is no patient with given id");
        
        /**
         * Checking the order medicine service offered by medical store to patient.
         */
        try {
        	logger.info("Starting order medicine service");
        	logger.info("These medicines ordered successfully: " + patientService.orderMedicine("ABC"));
        }
        catch(UserNameException|PrescriptionException exc) {
        	logger.info(exc.getMessage());
        }
    }
}

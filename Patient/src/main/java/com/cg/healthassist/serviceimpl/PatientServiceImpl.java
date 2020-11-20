package com.cg.healthassist.serviceimpl;

import java.util.*;

import com.cg.healthassist.model.*;
import com.cg.healthassist.service.PatientService;
import com.cg.healthassist.dao.*;
import com.cg.healthassist.daoimpl.*;
import com.cg.healthassist.exception.PrescriptionException;
import com.cg.healthassist.exception.UserNameException;

/**
 * Implement all the services need by patient from life line application.
 * @author Aman Soni
 *
 */
public class PatientServiceImpl implements PatientService {

	@Override
	public List<Doctor> searchDoctor(String speciality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bookDoctorAppointment(String speciality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalStore searchMedicalStore(String medicineName){
		MedicalStoreDAOImpl medicalStoreDao = new MedicalStoreDAOImpl();
		List<MedicalStore> medicalStoreList = medicalStoreDao.findAll();
		for(MedicalStore medicalStore:medicalStoreList) {
			List<Medicine> medicineList = medicalStore.getMedicineList();
			for(Medicine medicineAvailableInMedicalStore:medicineList) {
				if(medicineAvailableInMedicalStore.getName().equalsIgnoreCase(medicineName)) {
					return medicalStore;
				}
			}
			
		}
		return null;
	}

	@Override
	public List<String> orderMedicine(String patientUserName) throws UserNameException,PrescriptionException{
		PatientDAOImpl patientDao = new PatientDAOImpl();
		long patientId = -1;
		List<String> medicineSuccessfullyOrdered = new ArrayList<>();
		Map<Long,String> credentials = Patient.getPatientCredentials();
		Set<Long> patientIds = credentials.keySet();
		for(Long id:patientIds) {
			if(credentials.get(id).equalsIgnoreCase(patientUserName)) {
				patientId = id;
				break;
			}
		}
		if(patientId==-1) {
			throw new UserNameException("Please provide a correct user name");
		}
		else {
			Patient patient = patientDao.findByPatientId(patientId);
			if(patient.getPrescription()==null) {
				throw new PrescriptionException("Please upload the doctor prescription");
			}
			else {
				List<String> medicineListToOrder = Arrays.asList(patient.getPrescription().split(","));
				MedicalStoreDAO medicalStoreDao = new MedicalStoreDAOImpl();
				List<MedicalStore> medicalStores = medicalStoreDao.findAll();
				for(MedicalStore medicalStoreAvailable:medicalStores) {
					List<Medicine> medicineAvailable = medicalStoreAvailable.getMedicineList();
					for(Medicine medicine:medicineAvailable) {
						for(String medicineOrder:medicineListToOrder) {
							if(medicineOrder.equalsIgnoreCase(medicine.getName())) {
								boolean checkDuplicate = false;
								for(String medicineOrdered:medicineSuccessfullyOrdered) {
									if(medicineOrdered.equalsIgnoreCase(medicine.getName()))
										checkDuplicate = true;
								}
								if(!checkDuplicate) {
									medicineSuccessfullyOrdered.add(medicine.getName());
								}
							}
						}
					}
				}
			}
		}
		return medicineSuccessfullyOrdered;
	}

	@Override
	public boolean uploadPrescriptionCopy(long patientId,String prescription) {
		PatientDAOImpl patientDao = new PatientDAOImpl();
		boolean status = patientDao.update(prescription, patientId);
		return status;
		
	}

}

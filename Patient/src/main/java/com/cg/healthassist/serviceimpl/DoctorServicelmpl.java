package com.cg.healthassist.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.cg.healthassist.service.DoctorService;
import com.cg.healthassist.service.PatientService;
import com.cg.healthassist.model.Doctor;
import com.cg.healthassist.dao.DoctorDAO;
import com.cg.healthassist.daoimpl.DoctorDAOImpl;

/**
 * A class which implements the service needed by patient from doctor.
 * @author Aman Soni
 *
 */
public class DoctorServicelmpl implements DoctorService
{
	/**
	 * List of doctor.
	 */
	List<Doctor> doctorWithGivenSpecialityList = new ArrayList<>();
	/**
	 * A dao instance used for CRUD operation in doctor database.
	 */
	private DoctorDAO dao;
	
	/**
	 * Create an instance of doctor dao use to connect with doctor database.
	 */
	public void DoctorServiceImpl()
	{
		dao = new DoctorDAOImpl();
	}
	
	@Override
	public List<Doctor> searchDoctor(String speciality) 
	{
		DoctorDAOImpl dao = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the speciality of the doctor to be searched");
		String doctorSpeciality = sc.next();
		List<Doctor> doctorList = dao.findAll();
		for(Doctor specialization:doctorList)
		{
			
	}
		return doctorList;
	}
	@Override
	public String bookDoctorAppointment(String speciality) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the speciality of the doctor to be searched");
		String doctorSpeciality = sc.next();
		List<Doctor> doctorList = dao.findAll();
		for(int i=0;i<doctorList.size();i++)
		{
			
			
		}
		
		return getDetails();
		
	}
	private String getDetails() {
		List<Doctor> doctorList = dao.findAll();
		Doctor doctor = new Doctor();
		String details=doctor.getDoctorName()+doctor.getDoctorPhNo()+doctor.getSpecialization();
		return details;
	}

}

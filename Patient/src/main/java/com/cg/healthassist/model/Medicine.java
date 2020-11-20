package com.cg.healthassist.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Medicine {
	/**
	 * Name of the medicine.
	 */
	private String name;
	/**
	 * Price of the medicine.
	 */
	private double price;
	/**
	 * Company name for medicine.
	 */
	private String companyName;
	/**
	 * Expiry date of the medicine.
	 */
	private String expiryDate;
	/**
	 * Manufacturing date of the medicine.
	 */
	private String manufacturingDate;
	
	public Medicine() {
		super();
	}
	
	/**
	 * Create a new instance of the medicine on given parameters.
	 * @param name
	 * @param price
	 * @param companyName
	 * @param expiryDate
	 * @param manufacturingDate
	 */
	public Medicine(String name, double price, String companyName, String expiryDate, String manufacturingDate) {
		super();
		this.name = name;
		this.price = price;
		this.companyName = companyName;
		this.expiryDate = expiryDate;
		this.manufacturingDate = manufacturingDate;
	}
	
	/**
	 * @return the name of the medicine.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the medicine.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price of the medicine.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the medicine.
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the company name of the medicine.
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Set the company name of the medicine.
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the expiry date of the medicine.
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	
	/**
	 * Set the expiry date of the medicine.
	 * @param expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the manufacturing date of the medicine.
	 */
	public String getManufacturingDate() {
		return manufacturingDate;
	}
	
	/**
	 * Set the manufacturing date of the medicine.
	 * @param manufacturingDate
	 */
	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	
	@Override
	public String toString() {
		return "Medicine [name=" + name + ", price=" + price + ", companyName=" + companyName + ", expiryDate="
				+ expiryDate + ", manufacturingDate=" + manufacturingDate + "]";
	}
	
	
	
	

}

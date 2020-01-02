package com.project.dm.loanorigination;

import java.util.Date;

public class Applicant {
	
	private String name;
	private Date dateOfBirth;
	private String address;
	private String uniqueId;
	private Gender gender;
	private Employment employment;
	
	private int noOfPreviousDefaults;
	
	private String creditScore;
	private boolean blackListed;  
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the employment
	 */
	public Employment getEmployment() {
		return employment;
	}
	/**
	 * @param employment the employment to set
	 */
	public void setEmployment(Employment employment) {
		this.employment = employment;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the creditScore
	 */
	public String getCreditScore() {
		return creditScore;
	}
	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	
	/**
	 * @return the blackListed
	 */
	public boolean isBlackListed() {
		return blackListed;
	}
	/**
	 * @param blackListed the blackListed to set
	 */
	public void setBlackListed(boolean blackListed) {
		this.blackListed = blackListed;
	}
	/**
	 * @return the noOfPreviousDefaults
	 */
	public int getNoOfPreviousDefaults() {
		return noOfPreviousDefaults;
	}
	/**
	 * @param noOfPreviousDefaults the noOfPreviousDefaults to set
	 */
	public void setNoOfPreviousDefaults(int noOfPreviousDefaults) {
		this.noOfPreviousDefaults = noOfPreviousDefaults;
	}
	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	
	
	
	

}

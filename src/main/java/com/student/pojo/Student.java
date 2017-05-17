package com.student.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String usn;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfJoin;
	private Date dateOfBirth;
	private String branch;
	private String mobile;
	private String fatherName;
	private String motherName;
	private String address;
	private int currentYear;
	private int currentSemester;
	
	
	/**
	 * @return the currentYear
	 */
	public int getCurrentYear() {
		return currentYear;
	}
	/**
	 * @param currentYear the currentYear to set
	 */
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	/**
	 * @return the currentSemester
	 */
	public int getCurrentSemester() {
		return currentSemester;
	}
	/**
	 * @param currentSemester the currentSemester to set
	 */
	public void setCurrentSemester(int currentSemester) {
		this.currentSemester = currentSemester;
	}
	/**
	 * @return the usn
	 */
	public String getUsn() {
		return usn;
	}
	/**
	 * @param usn the usn to set
	 */
	public void setUsn(String usn) {
		this.usn = usn;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfJoin
	 */
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	/**
	 * @param dateOfJoin the dateOfJoin to set
	 */
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
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
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}
	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
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
}

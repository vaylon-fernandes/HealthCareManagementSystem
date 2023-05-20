package com.healthcare.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7641696930904900894L;
	private int serialNo;
	private String patientName,address,phoneNo,disease,gender; 
	private LocalDate admitDate;
	private double annualIncome; 
	private RoomType roomType;
	
	
	
	public Patient() {
		super();
	}

	public Patient(int serialNo, String patientName, String address, String phoneNo, String disease, String gender,
			LocalDate admitDate, double annualIncome, RoomType roomType) {
		super();
		this.serialNo = serialNo;
		this.patientName = patientName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.disease = disease;
		this.gender = gender;
		this.admitDate = admitDate;
		this.annualIncome = annualIncome;
		this.roomType = roomType;
	}
	
	// getters and setters
	
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LocalDate getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(LocalDate admitDate) {
		this.admitDate = admitDate;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Patient [serialNo=" + serialNo + ", patientName=" + patientName + ", address=" + address + ", phoneNo="
				+ phoneNo + ", disease=" + disease + ", gender=" + gender + ", admitDate=" + admitDate
				+ ", annualIncome=" + annualIncome + ", roomType=" + roomType + "]";
	}
	
}

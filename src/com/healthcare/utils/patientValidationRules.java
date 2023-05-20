package com.healthcare.utils;

import java.time.LocalDate;

import com.healthcare.core.Patient;
import com.healthcare.core.RoomType;
import com.healthcare.custom_exceptions.PatientEntryException;

public interface patientValidationRules {
	public static Patient validateAllInputs(int serialNo, String patientName, String address, String phoneNo, String disease, String gender,
			String admitDate, double annualIncome, String roomType) throws Exception {
		LocalDate validDate = parseAndValidateAdmitDate(admitDate);	
		RoomType validRoomType = RoomType.valueOf(roomType);
			return new Patient(serialNo, patientName, address, phoneNo, disease, gender,
					validDate, annualIncome, validRoomType);
		}
	
	public static RoomType parseAndValidateRoomType(String roomType){
		return RoomType.valueOf(roomType);
	}
	
	public static LocalDate parseAndValidateAdmitDate(String date) throws Exception {
			LocalDate validAdmitDate = LocalDate.parse(date);
			if(!validAdmitDate.equals(LocalDate.now())) {
				throw new PatientEntryException("Entered invalid date");
			}
			return validAdmitDate;
	}
}

package com.healthcare.tester;

import static com.healthcare.utils.IOutils.restorePatientDetails;
import static com.healthcare.utils.IOutils.storePatientDetails;
import static com.healthcare.utils.patientValidationRules.parseAndValidateRoomType;
import static com.healthcare.utils.patientValidationRules.validateAllInputs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.healthcare.core.Patient;
import com.healthcare.core.RoomType;

public class HealthCare implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5358090450181444141L;

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
//		List<Patient> patients= new ArrayList<>();
			System.out.print("Enter Filename: ");
			String fileName;
			fileName= sc.next();
			ArrayList<Patient> patients = restorePatientDetails(fileName);
			boolean exit = false;
			while (!exit) {
//				System.out.println("enter filename to get records: ");
//				String fileName = sc.next();
				System.out.println(
						"1. Add Patient Records 2. Display Patients 3. Display patient in Room type 4. Remove Diabetic Patients 5. Change ICU room type to Special 6. Sort patients based on Gender");
				System.out.println("Enter Choice");
				try {
					switch (sc.nextInt()) {
					case 10:
						storePatientDetails(fileName, patients);
						exit = true;
						break;
					case 1:
						System.out.println(
								"Enter serialNo, patientName, address, phoneNo, disease, gender, admitDate, annualIncome, roomType");
						patients.add(validateAllInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextDouble(), sc.next()));
						// 1 N A 888 DIABETES MALE 2023-05-20 1000 ICU
						break;
					case 2:
						for (Patient p : patients) {
							System.out.println(p);
						}
						break;
					case 3:
						System.out.println("Enter Room Type: ");
						RoomType roomType = parseAndValidateRoomType(sc.next());
						System.out.println("Details of patients in room " + roomType.name() + ": ");
						for (Patient p : patients) {
							if (p.getRoomType().equals(roomType)) {
								System.out.println(p);
							}
						}
						break;
					case 4:
						patients.removeIf(p->p.getDisease().toLowerCase().equals("diabetes"));
						System.out.println("Removed patients having Diabetes");
						break;
					default:
						break;
					case 5:
						patients.stream()
						.filter(p->p.getRoomType().equals(RoomType.ICU))
						.forEach(p->p.setRoomType(RoomType.SPECIAL));
						break;
					case 6:
						Collections.sort(patients, new Comparator<Patient>() {
							@Override 
							public int compare(Patient patient, Patient anotherPatient) {
								return patient.getGender().compareTo(anotherPatient.getGender());
							}
				
						});
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

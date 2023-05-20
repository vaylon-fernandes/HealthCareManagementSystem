package com.healthcare.custom_exceptions;

@SuppressWarnings("serial")
public class PatientEntryException extends  Exception{

	public PatientEntryException(String message) {
		super(message);
	}
	
}

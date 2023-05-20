package com.healthcare.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.healthcare.core.Patient;

public interface IOutils {
	static void storePatientDetails(String fileName, ArrayList<Patient> patients) throws IOException {
		// Java App --> OOS --> FOS --> bin file
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(patients);// serialization
			System.out.println("Created");
		}
	}

	// add a static method for restoring product details , using de-ser from bin
	// file
	@SuppressWarnings("unchecked")
	static ArrayList<Patient> restorePatientDetails(String fileName) throws IOException,ClassNotFoundException{
		// attach data strms for de-ser.
		// Java App <----- OIS: deserializer<-----FIS : node strm<---- Bin File
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (ArrayList<Patient>)in.readObject();
		}
		catch(FileNotFoundException e){
			System.out.println("New file created...");
//			e.printStackTrace();
			return new ArrayList<Patient>();
		}
		
	}
}

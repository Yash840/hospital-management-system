package com.cross.hospital.db;

import com.cross.hospital.model.Patient;

import java.util.HashMap;

public class PatientDB {
    private static HashMap<String, Patient>  patientDB = new HashMap<>();

    public static void addPatient(Patient p){
        if(p == null){
            System.out.println("Patient Object Required");
            return ;
        }

        patientDB.put(p.getId(), p);
        System.out.println("New Patient Added Successfully");
    }

    public static void removePatient(String id){
        if(id.isEmpty() || id == null){
            System.out.println("Id is required");
            return ;
        }

        patientDB.remove(id);
        System.out.println("Patient Removed Successfully");
    }

    public static Patient fetchPatient(String id){
        if(id.isEmpty() || id == null){
            System.out.println("Id is required");
            return null;
        }

        return patientDB.get(id);
    }
}

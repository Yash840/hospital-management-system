package com.cross.hospital.cmenus;

import com.cross.hospital.db.PatientDB;
import com.cross.hospital.model.Patient;
import com.cross.hospital.model.Staff;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.cross.hospital.Main.user;
import static com.cross.hospital.Text.*;

public class DoctorMenu {
    private static String[] menuList = {
            "Admit Patient",
            "Diagnose Patient",
            "Read Patient Details",
            "Profile",
            "Terminate Entire Session"
    };

    private static Scanner inp = new Scanner(System.in);

    private static void admitPatient(){
        String fname, lname, dob, sex;
        double fees;

        subSection("Admit New Patient");

        try{
            System.out.print("Enter First Name Of Patient : ");
            fname = inp.next() + " ";
            System.out.print("Enter Last Name Of Patient : ");
            lname = inp.next();
            System.out.print("Enter DOB Of Patient as YYYY-MM-DD : ");
            dob = inp.next();
            System.out.print("Enter SEX of Patient (M, F, MF) : ");
            sex = inp.next();
            System.out.print("Enter Estimated Fees ₹ ");
            fees = inp.nextDouble();
        } catch (InputMismatchException e) {
            warning("Invalid Details, Try Again");
            declare("Process Admit Patient Terminated Due To : "+ e.toString());
            return ;
        }

        Patient p = new Patient(fname.concat(lname), LocalDate.parse(dob), fees);
        PatientDB.addPatient(p);
        success(String.format("Patient with ID %s and NAME %s, admitted successfully", p.getId(), p.getName()));
        declare("Task Admit Patient Completed");
    }

    private static void readPatientDetails(){
        String id;

        subSection("Read Patient Details");
        System.out.print("Enter Patient ID : ");
        try{
            id = inp.next();
        } catch (InputMismatchException e) {
            warning("Invalid Details, Try Again");
            declare("Process Read Patient Details Terminated Due To : "+ e.toString());
            return ;
        }

        Patient p = PatientDB.fetchPatient(id);
        System.out.println(p.getDetails());
        System.out.println("-------");
        System.out.println("Last Report of Patient");
        System.out.println(p.getRecentReport() != null ? p.getRecentReport().read() : "No Reports Available");

        declare("Process Read Patient Details Completed");
    }

    private static void diagnosePatient(){
        String id;

        System.out.print("Enter Patient Id to Diagnose : ");
        id = inp.next();

        Patient p = PatientDB.fetchPatient(id);
        if(p == null){
            warning("Patient Not Found, Entered ID might be incorrect");
            declare("Process Diagnose Patient Terminated due to Invalid ID");
            return ;
        }

        String subject, remarks, verdict ;
        paragraph("Create DIAGNOSIS REPORT");
        inp.nextLine();
        System.out.println("Enter Subject of Report : ");
        subject = inp.nextLine();
        System.out.println("Enter Remarks : ");
        remarks = inp.nextLine();
        System.out.println("Enter Verdict : ");
        verdict = inp.nextLine();

        p.diagnose(subject, remarks, verdict, user.getName());
        success(String.format("Patient %s, Diagnosed Successfully", p.getId()));
        declare("Process Diagnose Patient Completed");
    }


    public static void start(){
        section(String.format("Welcome, %s ", user.getName()));
        while(true){
            paragraph("Choose What Do You Want : ");
            orderedList(menuList);
            System.out.print("\n" + user.getName() + " >>> ");
            byte choice = inp.nextByte();
            System.out.println();
            if(choice == 5) {
                warning("Session Terminated Forcefully");
                break;
            }

            switch (choice){
                case 1 : admitPatient();
                break;
                case 2: diagnosePatient();
                break;
                case 3: readPatientDetails();
                break;
                case 4: paragraph(user.details());
                break;
                default: break;
            }
        }
    }
}

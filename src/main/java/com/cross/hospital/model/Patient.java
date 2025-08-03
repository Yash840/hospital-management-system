package com.cross.hospital.model;

import com.cross.hospital.utils.Auth;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Patient {
    private static int PATIENT_SERIAL = 0;

    private String name;
    private String id;
    private Status status;
    private LocalDate dob;
    private double dueFees;
    private LinkedList<Report> reports = new LinkedList<>();
    private LinkedList<Receipt> receipts = new LinkedList<>();

    public Patient(String _name, LocalDate _dob, double _fees){
        this.id = Auth.generateId("PAT", PATIENT_SERIAL);
        this.name = _name;
        this.status = Status.ADMITTED;
        this.dob = _dob;
        this.dueFees = _fees;
    }

    public String getDetails(){
        return String.format(
                "\n====== PATIENT DETAILS ======\nID : %s\nNAME : %s\nDOB : %s\nFees Remaining : %.2f\n",
                this.id, this.name, this.dob.toString(), this.dueFees
        );
    }

    public String getId() { return this.id ; }
    public String getName() { return this.name ;}

    private void addReceipt(Receipt r){
        if(r == null){
            System.out.println("Receipt Object is Required");
            return ;
        }

        this.receipts.add(r);
    }

    private void addReport(Report r){
        if(r == null){
            System.out.println("Report Object is Required");
            return ;
        }

        this.reports.add(r);
    }

    public void payFees(double amt, String paidTo){
        if(amt <= 0){
            System.out.println("Invalid Amount");
            return ;
        }

        if(amt > this.dueFees){
            System.out.println("Excess Amount");
            return ;
        }

        Receipt r = new Receipt(amt, paidTo, this.name);

        this.addReceipt(r);

        this.dueFees -= amt;
        System.out.println(amt + " Amount Paid Successfully");
        System.out.println(this.dueFees + " Remaining");
        return ;
    }

    public void diagnose(String subject, String remarks, String verdict, String diagnosedBy){
        Report r = new Report(subject, remarks,verdict, diagnosedBy, this.name);

        addReport(r);
        System.out.println("Patient Diagnosed Successfully, Check reports for further details");
    }

    public Report getRecentReport(){
        if(this.reports.isEmpty()){
            return null;
        }

        return this.reports.getLast();
    }

    public Receipt getRecentReceipt(){
        if(this.reports.isEmpty()){
            return null;
        }

        return this.receipts.getLast();
    }
}

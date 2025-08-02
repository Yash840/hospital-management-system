package com.cross.hospital.model;


import java.time.LocalDate;

public class Doctor extends Staff {

    public Doctor(String _name, String _password, Dept _dept, LocalDate _dob, Integer _salary){
        super(_name, _password, Role.DOCTOR, _dept, _dob, _salary);
    }
}

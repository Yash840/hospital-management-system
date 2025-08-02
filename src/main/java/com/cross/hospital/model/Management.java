package com.cross.hospital.model;

import java.time.LocalDate;

public class Management extends Staff{
    public Management(String _name, String _password, Dept _dept, LocalDate _dob, Integer _salary){
        super(_name, _password, Role.MANAGEMENT, _dept, _dob, _salary);
    }
}

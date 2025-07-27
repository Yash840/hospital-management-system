package com.cross.hospital.model;

import com.cross.hospital.utils.Auth;

import java.time.LocalDate;

public class Staff {
    public static int STAFF_SERIAL = 0;

    private String name;
    private String id;
    private String password;
    private Role role;
    private Dept dept;
    private LocalDate dob;
    private Integer salary;

    public Staff(String _name, String _password, Role _role, Dept _dept, LocalDate _dob, Integer _salary){
        this.name = _name;
        this.id = Auth.generateId("HSP",STAFF_SERIAL);
        this.password = Auth.securePassword(_password);
        this.role = _role;
        this.dept = _dept;
        this.dob = _dob;
        this.salary = _salary;

        STAFF_SERIAL++;
    }

    public String details(){
        return String.format("ID : %s\nNAME : %s\nROLE : %s\nDEPARTMENT : %s\nDate OF Birth : %s\n", this.id, this.name, this.role.name(), this.dept.name(),this.dob.toString());
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getRole(){
        return this.role.name();
    }

    public String getDept(){
        return this.dept.name();
    }

    public String getDob(){
        return this.dob.toString();
    }

    public int getSalary(){
        return this.salary;
    }

    public void changeDept(Dept newDept){
        this.dept = newDept;
    }

    public void changeRole(Role newRole){
        this.role = newRole;
    }

    @Override
    public String toString(){
        return String.format("%s-%s(%s)-->%s",this.role.name(),this.name,this.dept.name(),this.id);
    }
}

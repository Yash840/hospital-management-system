package com.cross.hospital;

import com.cross.hospital.model.Dept;
import com.cross.hospital.model.Role;
import com.cross.hospital.model.Staff;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to HMS");
        Staff s1 = new Staff("Cross","iAmCross", Role.DOCTOR, Dept.CARDIO, LocalDate.parse("1990-01-01"),100000);

        System.out.println(s1.details());
        System.out.println(s1);

    }
}

package com.cross.hospital;

import com.cross.hospital.cmenus.DoctorMenu;
import com.cross.hospital.cmenus.Initializer;
import com.cross.hospital.model.*;
import static com.cross.hospital.db.StaffDB.*;

import java.time.LocalDate;


public class Main {
    public static Staff user;

    public static void main(String[] args) {
        Staff s1 = new Doctor("Manoj", "iAmManoj", Dept.CARDIO, LocalDate.parse("2000-01-01"), 100_000);
        addStaff(s1);

        user = Initializer.getUser();
        DoctorMenu.start();
    }
}

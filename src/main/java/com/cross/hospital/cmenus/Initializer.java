package com.cross.hospital.cmenus;

import java.util.Scanner;

import com.cross.hospital.model.Staff;
import static com.cross.hospital.Text.*;
import com.cross.hospital.db.StaffDB;
import com.cross.hospital.utils.Auth;

public class Initializer {

    public static Staff user = null;
    private static final Scanner inp = new Scanner(System.in);

    public static Staff getUser(){
        title("Cross HMS Console");
        paragraph("You need Login first before further proceeding..");
        paragraph("Contact admin, if you are not registered");

        while(user == null){
            normal("Enter Your Staff Id : ");
            String id = inp.next();
            normal("Enter Your Password : ");
            String password = inp.next();

            if(id.equals(".tm") || password.equals(".tm")) break;

            Staff s = StaffDB.fetchStaff(id);
            boolean isValidUser = s != null && Auth.validatePassword(password, s.securedString());
            if(isValidUser){
                user = s;
                break ;
            }else {
                warning("Incorrect Credentials, Enter Details Again");
            }
        }

        return user;
    }
}

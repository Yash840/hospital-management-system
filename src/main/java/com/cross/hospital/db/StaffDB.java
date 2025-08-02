package com.cross.hospital.db;

import com.cross.hospital.model.Staff;

import java.util.HashMap;

public class StaffDB {
    private static HashMap<String, Staff> staffDB = new HashMap<>();

    public static void addStaff(Staff s){
        if(s == null){
            System.out.println("Staff Object Required");
            return ;
        }

        staffDB.put(s.getId(), s);
        System.out.println("New Staff Added Successfully");
    }

    public static void removeStaff(String id){
        if(id.isEmpty() || id == null){
            System.out.println("Id is required");
            return ;
        }

        staffDB.remove(id);
        System.out.println("Staff Removed Successfully");
    }

    public static Staff fetchStaff(String id){
        if(id.isEmpty() || id == null){
            System.out.println("Id is required");
            return null;
        }

        return staffDB.get(id);
    }
}

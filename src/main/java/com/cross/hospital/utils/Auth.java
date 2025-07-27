package com.cross.hospital.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Auth {
    public static String securePassword(String inpPassword){
        return BCrypt.hashpw(inpPassword, BCrypt.gensalt());
    }

    public static boolean validatePassword(String inpPassword, String actualPassword){
        return BCrypt.checkpw(inpPassword, actualPassword);
    }

    public static String generateId(String baseString, int serial){
        return baseString + serial;
    }
}

package com.cross.hospital.gui;

import java.net.URL;

public class ResourceTest {
    public static void main(String[] args) {
        // Test if we can find the FXML resource
        URL resource = ResourceTest.class.getResource("/main.fxml");

        if (resource != null) {
            System.out.println("✓ FXML file found at: " + resource);
        } else {
            System.out.println("✗ FXML file NOT found!");

            // Try different paths
            String[] testPaths = {
                    "/main.fxml",
                    "/main.fxml",
                    "main.fxml",
                    "main.fxml"
            };

            for (String path : testPaths) {
                URL testResource = ResourceTest.class.getResource(path);
                System.out.println("Trying " + path + ": " + (testResource != null ? "FOUND" : "NOT FOUND"));
            }
        }
    }
}
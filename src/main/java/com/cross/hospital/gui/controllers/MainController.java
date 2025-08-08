package com.cross.hospital.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.application.Platform;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the controller
        System.out.println("MainController initialized successfully!");
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    @FXML
    private void showPatientManagement() {
        showAlert("Patient Management", "Patient management feature will be implemented here.");
    }

    @FXML
    private void showDoctorManagement() {
        showAlert("Doctor Management", "Doctor management feature will be implemented here.");
    }

    @FXML
    private void showAbout() {
        showAlert("About", "Hospital Management System\nA comprehensive hospital management solution built with JavaFX.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
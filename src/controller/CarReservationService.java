package controller;

import model.Resource;
import view.Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class CarReservationService {

    public static void main(String[] args) {
        // Set default resource bundle
        String lang = "de";
        Locale locale = new Locale(lang);
        Language.resourceBundle = ResourceBundle.getBundle("view.Bundle", locale);

        reserveCar();
    }


    public static void reserveCar() {

        // Create Resource
        ResourceService resourceService = new ResourceService();
        Resource selectedResource = resourceService.getSelectedResource();

        // Create Person

        // Authenticate Person

        // Pay Resource

        // Create Booking

        // Add Content

        // Show Statistics

    }

}

package controller;

import model.Resource;

public class CarReservationService {

    public static void main(String[] args) {
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

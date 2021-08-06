package controller;

import model.*;
import view.SelectUseCaseView;

import java.time.LocalDate;

public class CarReservationService {

    private Person person;
    private AuthenticationService authenticationService;

//    public static void main(String[] args) {
//        selectUseCase();
//    }

    public void selectUseCase() {
        while (true) {
            new SelectUseCaseView(this).display();
        }
    }

    public void reserveResource() {
        Resource selectedResource = new ResourceService().getSelectedResource();
        Payment payment = new PaymentService().payAmount(new CurrencyAmount(selectedResource.getPrice(),Currency.EURO));//todo Currency in Resource?
        Booking booking = new BookingService().createBooking(selectedResource, payment);
        new ContentService().addContent(null, LocalDate.now());     //todo Booking übergeben
    }

    // Create Person
    public void createPerson() {
        person = new PersonService().createPerson();
        authenticationService = new AuthenticationService((Subject) person);
    }
    // Authenticate Person
    public void authenticateSubject() {
        authenticationService.authenticateSubject();
    }

    // Show Content
    public void showContent() {
        new ContentService();    //todo show in Content
    }

    // Show Statistics
    public void showStatistics(){ //todo Auswahl der "Filter"
    }

    public void showAllResources() {
        new ResourceService().getSelectedResource();
    }

    public void logOut() {
        authenticationService.logout();
    }

    public Person getPerson() {
        return person;
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}

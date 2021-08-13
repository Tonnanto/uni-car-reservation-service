package controller;

import model.*;
import view.SelectUseCaseView;

import java.time.LocalDate;

public class CarReservationService {

    private Person person;
    private AuthenticationService authenticationService;
    private ContentService contentService;
    private StatisticsService statisticsService;

//    public static void main(String[] args) {
//        selectUseCase();
//    }

    public void selectUseCase() {
        contentService = new ContentService();
        statisticsService = new StatisticsService(contentService.getRoot());
        while (true) {
            new SelectUseCaseView(this).display();
        }
    }

    public void reserveResource() {
        Resource selectedResource = new ResourceService().getSelectedResource();
        Payment payment = new PaymentService().payAmount(new CurrencyAmount(selectedResource.getPrice(), Currency.EURO));//todo Currency in Resource?
        Booking booking = new BookingService().createBooking(selectedResource, payment);
        contentService.addContent(new BookingFile(booking));
    }

    // Create Person
    public void createPerson() {
        person = new PersonService().createPerson();
        if (person instanceof Subject)
            authenticationService = new AuthenticationService((Subject) person);
    }

    // Authenticate Person
    public void authenticateSubject() {
        authenticationService.authenticateSubject();
    }

    // Show Content
    public void showContent() {
        contentService.showContent();
    }

    // Show Statistics
    public void showStatistics() { //todo Auswahl der "Filter"
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

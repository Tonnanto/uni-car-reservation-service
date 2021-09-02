package controller;

import model.*;
import view.SelectCurrencyView;
import view.SelectLanguageView;
import view.SelectUseCaseView;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;


public class CarReservationService {

    private Person person;
    private AuthenticationService authenticationService;
    private ContentService contentService;
    private StatisticsService statisticsService;
    private boolean closeProgramm;

    public void selectUseCase() {
        contentService = new ContentService();
        statisticsService = new StatisticsService(contentService.getRoot());

        // Add some demo data
        contentService.addDemoBookings(25);

        // Prompt User to select language and currency
        promptConfig();

        while (!closeProgramm) {
            new SelectUseCaseView(this).display();
        }
    }

    public void reserveResource() {
        Resource selectedResource = new ResourceService().getSelectedResource();
        if(selectedResource == null) return;
        Payment payment = new PaymentService().payAmount(selectedResource.getPrice());
        Booking booking = new BookingService().createBooking(selectedResource, payment, person, LocalDate.now());
        contentService.addContent(new BookingFile(booking));
    }

    // Create Person
    public void createPerson() {
        person = new PersonService().createPerson();
        if (person instanceof Subject)
            authenticationService = new AuthenticationService((Subject) person);
        else
            authenticationService = null;
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
    public void showStatistics() {
        statisticsService.showStatistics();
    }

    public void showAllResources() {
        new ResourceService().showAllResources();
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

    public void setLanguage(Language language) {
        Locale locale = new Locale(language.countryCode());
        Config.resourceBundle = ResourceBundle.getBundle("view.Bundle", locale);
    }

    public void setCurrency(Currency currency) {
        Config.currency = currency;
    }

    public void promptConfig() {
        new SelectLanguageView(this).display();
        new SelectCurrencyView(this).display();
    }

    public void closeProgramm() {
        this.closeProgramm = true;
    }
}

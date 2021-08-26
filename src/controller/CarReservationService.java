package controller;

import model.*;
import model.Language;
import view.SelectCurrencyView;
import view.SelectLanguageView;
import view.SelectUseCaseView;

import java.util.Locale;
import java.util.ResourceBundle;


public class CarReservationService {

    private Person person;
    private AuthenticationService authenticationService;
    private ContentService contentService;
    private StatisticsService statisticsService;

    public void selectUseCase() {
        contentService = new ContentService();
        statisticsService = new StatisticsService(contentService.getRoot());

        promptConfig();

        while (true) {
            new SelectUseCaseView(this).display();
        }
    }

    public void reserveResource() {
        Resource selectedResource = new ResourceService().getSelectedResource();
        Payment payment = new PaymentService().payAmount(selectedResource.getPrice());
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
}

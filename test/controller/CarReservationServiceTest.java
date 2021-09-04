package controller;

import controller.commands.SetCurrencyCommand;
import controller.commands.SetLanguageCommand;
import model.Currency;
import model.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarReservationServiceTest {

    private static CarReservationService carReservationService;

    @BeforeAll
    private static void setUp() {
        carReservationService = new CarReservationService();
    }

    @Test
    protected void canCarBeReserved() {
        // PersonService Tests
        PersonServiceTest.setUp();
        new PersonServiceTest().canPersonBeCreated();

        // AuthenticationService Tests
        AuthenticationServiceTest authenticationServiceTest = new AuthenticationServiceTest();
        authenticationServiceTest.canSubjectBeAuthenticatedWithPassword();
        authenticationServiceTest.canSubjectBeAuthenticatedWithFinger();
        authenticationServiceTest.canSubjectBeAuthenticatedWithEye();

        // ResourceService Tests
        ResourceServiceTest.setUp();
        new ResourceServiceTest().canResourceBeSelected();

        // PaymentService Tests
        PaymentServiceTest.setUp();
        new PaymentServiceTest().canAmountBePayed();

        // BookingService Tests
        BookingServiceTest bookingServiceTest = new BookingServiceTest();
        bookingServiceTest.canBookingBeCreatedInGerman();
        bookingServiceTest.canBookingBeCreatedInEnglish();

        // ContentService Tests
        ContentServiceTest.setUp();
        ContentServiceTest contentServiceTest = new ContentServiceTest();
        contentServiceTest.canContentBeAdded();
        contentServiceTest.canContentBeShown();

        // StatisticsService Tests
        StatisticsServiceTest statisticsServiceTest = new StatisticsServiceTest();
        statisticsServiceTest.canSummaryBeCreated();
        statisticsServiceTest.canInitialSummaryBeCreated();
        statisticsServiceTest.canGermanBookingsPaidByPayPalBeGotten();
        statisticsServiceTest.canGermanBookingsPaidByGoogleWalletBeGotten();
        statisticsServiceTest.canGermanBookingsPaidByMoneyWalletBeGotten();
        statisticsServiceTest.canEnglishBookingsPaidByPayPalBeGotten();
        statisticsServiceTest.canEnglishBookingsPaidByGoogleWalletBeGotten();
        statisticsServiceTest.canEnglishBookingsPaidByMoneyWalletBeGotten();
    }

    @Test
    protected void canLanguageBeSelected() {
        for (Language language: Language.values()) {
            new SetLanguageCommand(carReservationService, language).execute();
            Assertions.assertEquals(language.countryCode(), Config.resourceBundle.getLocale().getLanguage());
        }
    }

    @Test
    protected void canCurrencyBeSelected() {
        for (Currency currency: Currency.values()) {
            new SetCurrencyCommand(carReservationService, currency).execute();
            Assertions.assertEquals(currency, Config.currency);
        }
    }
}


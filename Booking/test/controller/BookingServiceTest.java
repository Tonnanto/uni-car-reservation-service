package controller;

import controller.commands.SetBookingBuilderCommand;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BookingServiceTest {

    @Test
    void canBookingBeCreatedInEnglish() {
        Resource resource = new Car("Benz", new CurrencyAmount(200, Currency.US_DOLLAR));
        Payment payment = new PayPalPayment(new CurrencyAmount(200, Currency.EURO));
        payment.authenticateCustomer("Jonas@Harms.de", "123456");
        BookingService bookingService = new BookingService();

        // SetBookingBiulderCommand executen
        new SetBookingBuilderCommand(bookingService, Language.ENGLISH).execute();
        // Prüfen ob der richtige booking builder ausgewählt wurde
        Assertions.assertTrue(bookingService.getBookingBuilder() instanceof EnglishBookingBuilder);
        // BookingDirector erstellen
        BookingDirector bookingDirector = new BookingDirector(bookingService.getBookingBuilder());
        // Booking builden (.createBooking(resource, payment);)
        bookingDirector.createBooking(resource, payment, new NaturalPerson(86), LocalDate.now());
        // Booking getten
        // Prüfen ob Booking korrekt ist
        Assertions.assertEquals(Language.ENGLISH, bookingDirector.getBooking().getLanguage());
    }

    @Test
    void canBookingBeCreatedInGerman() {
        Resource resource = new Car("VW", new CurrencyAmount(300, Currency.EURO));
        Payment payment = new PayPalPayment(new CurrencyAmount(300, Currency.EURO));
        payment.authenticateCustomer("Anton@Stamme.de", "654321");
        BookingService bookingService = new BookingService();

        // SetBookingBiulderCommand executen
        new SetBookingBuilderCommand(bookingService, Language.GERMAN).execute();
        // Prüfen ob der richtige booking builder ausgewählt wurde
        Assertions.assertTrue(bookingService.getBookingBuilder() instanceof GermanBookingBuilder);
        // BookingDirector erstellen
        BookingDirector bookingDirector = new BookingDirector(bookingService.getBookingBuilder());
        // Booking builden (.createBooking(resource, payment);)
        bookingDirector.createBooking(resource, payment, new NaturalPerson(86), LocalDate.now());
        // Booking getten
        // Prüfen ob Booking korrekt ist
        Assertions.assertEquals(Language.GERMAN, bookingDirector.getBooking().getLanguage());
    }
}



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

        new SetBookingBuilderCommand(bookingService, Language.ENGLISH).execute();
        Assertions.assertTrue(bookingService.getBookingBuilder() instanceof EnglishBookingBuilder);
        BookingDirector bookingDirector = new BookingDirector(bookingService.getBookingBuilder());
        bookingDirector.createBooking(resource, payment, new NaturalPerson(86), LocalDate.now());
        Assertions.assertEquals(Language.ENGLISH, bookingDirector.getBooking().getLanguage());
    }

    @Test
    void canBookingBeCreatedInGerman() {
        Resource resource = new Car("VW", new CurrencyAmount(300, Currency.EURO));
        Payment payment = new PayPalPayment(new CurrencyAmount(300, Currency.EURO));
        payment.authenticateCustomer("Anton@Stamme.de", "654321");
        BookingService bookingService = new BookingService();

        new SetBookingBuilderCommand(bookingService, Language.GERMAN).execute();
        Assertions.assertTrue(bookingService.getBookingBuilder() instanceof GermanBookingBuilder);
        BookingDirector bookingDirector = new BookingDirector(bookingService.getBookingBuilder());
        bookingDirector.createBooking(resource, payment, new NaturalPerson(86), LocalDate.now());
        Assertions.assertEquals(Language.GERMAN, bookingDirector.getBooking().getLanguage());
    }
}



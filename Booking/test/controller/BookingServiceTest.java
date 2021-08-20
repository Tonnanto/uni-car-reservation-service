package controller;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BookingServiceTest {
    static private BookingService bookingService;

    @BeforeAll
    static void setUp() {
        bookingService = new BookingService();
    }

    @Test
    void canBookingBeCreated() {

        Resource resource = new Car("Benz", new CurrencyAmount(200, Currency.US_DOLLAR));
        Payment payment = new PayPalPayment(new CurrencyAmount(200, Currency.EURO));

        Booking booking = bookingService.createBooking(resource, payment);

        Assertions.assertNotNull(booking);
        Assertions.assertNotNull(booking.getHeader());
        Assertions.assertNotNull(booking.getBody());
        Assertions.assertNotNull(booking.getFooter());

        System.out.println(booking.getHeader());
        System.out.println(booking.getBody());
        System.out.println(booking.getFooter());
    }
}

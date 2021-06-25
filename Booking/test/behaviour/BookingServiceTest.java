package behaviour;

import controller.PaymentService;
import controller.ResourceService;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import structure.Booking;

class BookingServiceTest {
    static private BookingService bookingService;

    @BeforeAll
    static void setUp() {
        bookingService = new BookingService();
    }

    @Test
    void canBookingBeCreated() {

        Resource resource = new Car("Benz", 200);
        PaymentService paymentService = new PaymentService();
        paymentService.payAmount(new CurrencyAmount(500, Currency.EURO));

        Booking booking = bookingService.createBooking(resource, paymentService.getPaymentType());

        Assertions.assertNotNull(booking);
        Assertions.assertNotNull(booking.getHeader());
        Assertions.assertNotNull(booking.getBody());
        Assertions.assertNotNull(booking.getFooter());

        System.out.println(booking.getHeader());
        System.out.println(booking.getBody());
        System.out.println(booking.getFooter());
    }
}


package behaviour;

import controller.ResourceService;
import model.Car;
import model.PaymentType;
import model.Resource;
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
        Booking booking = bookingService.createBooking(resource, PaymentType.PAYPAL);

        Assertions.assertNotNull(booking);
        Assertions.assertNotNull(booking.getHeader());
        Assertions.assertNotNull(booking.getBody());
        Assertions.assertNotNull(booking.getFooter());

        System.out.println(booking.getHeader());
        System.out.println(booking.getBody());
        System.out.println(booking.getFooter());
    }
}


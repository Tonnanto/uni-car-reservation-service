package behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingTest {
    private BookingDirector bookingDirector;

    @BeforeEach
    void setUp(){

    }

    @Test
    void canBookingBeCreated() {
        bookingDirector = new BookingDirector();
        bookingDirector.setBookingBuilder(new GermanBookingBuilder());
        Assertions.assertTrue(bookingDirector.createBooking());
    }
}


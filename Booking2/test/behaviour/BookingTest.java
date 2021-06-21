package behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingTest {
    private BookingDirector bookingDirector;

    @BeforeEach
    void setUp() {
        bookingDirector = new BookingDirector();
    }

    @Test
    void canBookingBeCreated() {
        Assertions.assertTrue(bookingDirector.createBooking());
    }
}


package behaviour;

import structure.Booking;

public class BookingService {

    public Booking createBooking() { //todo Payment && Resource

        BookingBuilder bookingBuilder = new GermanBookingBuilder();
        // TODO: Prompt user to select language

        BookingDirector bookingDirector = new BookingDirector(bookingBuilder);
        bookingDirector.createBooking();
        return bookingDirector.getBooking();
    }
}

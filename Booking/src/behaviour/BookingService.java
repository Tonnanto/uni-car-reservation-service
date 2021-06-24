package behaviour;

import structure.Booking;

public class BookingService {

    /**
     * Create a new Booking in german or english with a text, resource and a Payment
     * @return new booking
     */

    public Booking createBooking() { //todo Payment && Resource

        BookingBuilder bookingBuilder = new GermanBookingBuilder();
        // TODO: Prompt user to select language

        BookingDirector bookingDirector = new BookingDirector(bookingBuilder);
        bookingDirector.createBooking();
        return bookingDirector.getBooking();
    }
}

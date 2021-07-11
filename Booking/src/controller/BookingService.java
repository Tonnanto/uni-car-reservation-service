package controller;

import model.*;

public class BookingService {

    /**
     * Create a new Booking in german or english with a text, resource and a Payment
     * @return new booking
     */

    public Booking createBooking(Resource resource, Payment payment) {

        BookingBuilder bookingBuilder = new GermanBookingBuilder();
        // TODO: Prompt user to select language

        BookingDirector bookingDirector = new BookingDirector(bookingBuilder);
        bookingDirector.createBooking(resource,payment);
        return bookingDirector.getBooking();
    }
}

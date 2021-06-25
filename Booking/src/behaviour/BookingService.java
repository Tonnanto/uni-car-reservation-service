package behaviour;

import model.PaymentType;
import model.Resource;
import structure.Booking;

public class BookingService {

    /**
     * Create a new Booking in german or english with a text, resource and a Payment
     * @return new booking
     */

    public Booking createBooking(Resource resource, PaymentType paymentType) {

        BookingBuilder bookingBuilder = new GermanBookingBuilder(resource,paymentType);
        // TODO: Prompt user to select language

        BookingDirector bookingDirector = new BookingDirector(bookingBuilder);
        bookingDirector.createBooking();
        return bookingDirector.getBooking();
    }
}

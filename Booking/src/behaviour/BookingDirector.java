package behaviour;

import model.PaymentType;
import model.Resource;
import structure.Booking;

public class BookingDirector {
    private final BookingBuilder bookingBuilder;

    public BookingDirector(BookingBuilder bookingBuilder) {
        this.bookingBuilder = bookingBuilder;
    }

    public Booking getBooking() {
        return bookingBuilder.getBooking();
    }

    /**
     * create a new Booking with a text
     */

    public void createBooking(Resource resource, PaymentType paymentType) {
        bookingBuilder.createNewBooking(resource, paymentType);
        bookingBuilder.buildHeader();
        bookingBuilder.buildBody();
        bookingBuilder.buildFooter();
    }
}

package behaviour;

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

    public void createBooking() {
        bookingBuilder.buildHeader();
        bookingBuilder.buildBody();
        bookingBuilder.buildFooter();
    }
}

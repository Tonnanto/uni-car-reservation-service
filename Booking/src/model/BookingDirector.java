package model;

import java.time.LocalDate;

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

    public void createBooking(Resource resource, Payment payment, Person customer, LocalDate date) {
        bookingBuilder.createNewBooking(resource, payment, customer, date);
        bookingBuilder.buildHeader();
        bookingBuilder.buildBody();
        bookingBuilder.buildFooter();
        bookingBuilder.buildLanguage();
    }
}

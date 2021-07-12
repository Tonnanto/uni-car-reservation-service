package controller;

import model.*;
import view.SelectLanguageView;
import view.ShowBookingView;

public class BookingService {

    private BookingBuilder bookingBuilder;

    /**
     * Create a new Booking in german or english with a text, resource and a Payment
     *
     * @return new booking
     */

    public Booking createBooking(Resource resource, Payment payment) {

        new SelectLanguageView(this).display();
        BookingDirector bookingDirector = new BookingDirector(this.bookingBuilder);
        bookingDirector.createBooking(resource, payment);
        new ShowBookingView(this, bookingDirector.getBooking()).display();
        return bookingDirector.getBooking();
    }

    public void setBookingBuilder(Language language) {
        switch (language) {
            case GERMAN -> this.bookingBuilder = new GermanBookingBuilder();
            case ENGLISH -> this.bookingBuilder = new EnglishBookingBuilder();
        }
    }
}

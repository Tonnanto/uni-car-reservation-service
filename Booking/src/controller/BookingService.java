package controller;

import model.*;
import view.ConfirmBookingView;
import view.Language;
import view.SelectLanguageView;

public class BookingService {

    private BookingBuilder bookingBuilder;

    /**
     * Create a new Booking in german or english with a text, resource and a Payment
     *
     * @param resource The Resource, that is selected
     * @param payment  The Payment, that is payed
     * @return new booking
     */

    public Booking createBooking(Resource resource, Payment payment) {

        BookingDirector bookingDirector = null;
        while (bookingBuilder == null) {        //for a the reset
            while (bookingBuilder == null)      //for a failed set
                new SelectLanguageView(this).display();
            bookingDirector = new BookingDirector(this.bookingBuilder);
            bookingDirector.createBooking(resource, payment);
            new ConfirmBookingView(this, bookingDirector.getBooking()).display();
        }
        assert bookingDirector != null;
        return bookingDirector.getBooking();
    }

    public void setBookingBuilder(Language language) {
        switch (language) {
            case GERMAN -> this.bookingBuilder = new GermanBookingBuilder();
            case ENGLISH -> this.bookingBuilder = new EnglishBookingBuilder();
        }
    }

    public void resetBooking() {
        bookingBuilder = null;
    }
}

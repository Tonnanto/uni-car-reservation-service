package model;

import behaviour.BookingDirector;
import behaviour.GermanBookingBuilder;
import structure.Booking;

public class BookingFile extends File {

    private static int bookingCount;

    private Booking booking;

    public BookingFile (String name) {
        super(name);
    }
    public BookingFile() {
        super("Booking_" + ++bookingCount);

        // TODO: temporary example Booking
        BookingDirector director = new BookingDirector(new GermanBookingBuilder());
        director.createBooking(new Car("sdf", 300.0), new PayPalPayment(new CurrencyAmount(300.0, Currency.EURO)));
        this.booking = director.getBooking();
    }

    public Booking getBooking() {
        return booking;
    }
}

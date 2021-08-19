package model;

import java.util.Random;

public class BookingFile extends File {

    private static int bookingCount;

    private Booking booking;

    public BookingFile(Booking booking) {
        super("Booking_" + ++bookingCount);
        this.booking = booking;
    }

    // TODO: temporary constructor
    public BookingFile(String name) {
        super(name);
    }

    // TODO: temporary constructor
    public BookingFile() {
        super("Booking_" + ++bookingCount);

        Random r = new Random();
        double price = r.nextInt(100000);
        // TODO: temporary example Booking
        BookingDirector director = new BookingDirector(r.nextBoolean() ? new GermanBookingBuilder() : new EnglishBookingBuilder());
        director.createBooking(new Car("sdf", price), new PayPalPayment(new CurrencyAmount(price, Currency.EURO)));
        this.booking = director.getBooking();
    }

    public Booking getBooking() {
        return booking;
    }

    /**
     * Returns a visual representation of the files content
     * @return visual representation for console output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());

        // TODO: create visual representation of content
        sb.append("\n>> Content <<");

        return sb.toString();
    }
}

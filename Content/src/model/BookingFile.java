package model;

public class BookingFile extends File {

    private static int bookingCount;

    public BookingFile (String name) {
        super(name);
    }
    public BookingFile() {
        // TODO: Store Booking object in this file
        super("Booking_" + ++bookingCount);
    }
}

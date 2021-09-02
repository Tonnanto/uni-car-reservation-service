package model;

public class BookingFile extends File {

    private static int bookingCount;

    private final Booking booking;

    public BookingFile(Booking booking) {
        super("Booking_" + ++bookingCount);
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    /**
     * Returns a visual representation of the files content
     *
     * @return visual representation for console output
     */
    @Override
    public String toString() {
        return getName() + "\n" + booking;
    }
}

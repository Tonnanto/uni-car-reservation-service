package model;

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

        // TODO: temporary example Booking
        BookingDirector director = new BookingDirector(new GermanBookingBuilder());
        director.createBooking(new Car("sdf", 300.0), new PayPalPayment(new CurrencyAmount(300.0, Currency.EURO)));
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

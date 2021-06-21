package behaviour;

import structure.Booking;

public abstract class BookingBuilder {
    private Booking booking;

    public Booking createNewBooking(Resource resource, PaymentType paymentType) {
        return null;
    }

    // TODO private?
    public abstract String buildHeader();

    public abstract String buildBody();

    public  abstract String buildFooter();

    public Booking getBooking() {
        return booking;
    }
}

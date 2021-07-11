package model;

public abstract class BookingBuilder {
    protected Booking booking;

    public void createNewBooking(Resource resource, Payment payment) {
        booking = new Booking(resource, payment);
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

    public abstract void buildLanguage();

    public Booking getBooking() {
        return booking;
    }
}

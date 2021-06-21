package behaviour;

import structure.Booking;

public abstract class BookingBuilder {
    private Booking booking;

    public Booking createNewBooking() {   //Todo Ressource & Payment einfügen und übergeben
        booking = new Booking();
        booking.setHeader(buildHeader());
        booking.setBody(buildBody());
        booking.setFooter(buildFooter());
        return booking;
    }

    // TODO private?
    public abstract String buildHeader();

    public abstract String buildBody();

    public abstract String buildFooter();

//    todo wird nicht benötigt?
    public Booking getBooking() {
        return booking;
    }
}

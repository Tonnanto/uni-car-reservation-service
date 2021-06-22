package behaviour;

import structure.Booking;

public abstract class BookingBuilder {
    protected Booking booking;

    public BookingBuilder() {   //Todo Ressource & Payment einfügen und übergeben
        booking = new Booking();
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

//    todo wird nicht benötigt?
    public Booking getBooking() {
        return booking;
    }
}

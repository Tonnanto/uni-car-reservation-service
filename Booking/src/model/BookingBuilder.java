package model;

import java.time.LocalDate;

public abstract class BookingBuilder {
    protected Booking booking;

    public void createNewBooking(Resource resource, Payment payment, Person customer, LocalDate date) {
        booking = new Booking(resource, payment, customer, date);
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

    public abstract void buildLanguage();

    public Booking getBooking() {
        return booking;
    }
}

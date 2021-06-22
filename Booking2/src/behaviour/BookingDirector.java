package behaviour;

import structure.Booking;

public class BookingDirector {
    private BookingBuilder bookingBuilder;

    public void setBookingBuilder(BookingBuilder bookingBuilder) {
        this.bookingBuilder = bookingBuilder;
    }

    public Booking getBooking(){
        return null;
        //TODO warum brauchen wir die methode??
    }

    public void createBooking() {    //Todo Ressource & Payment einfügen und übergeben
        bookingBuilder.buildHeader();
        bookingBuilder.buildBody();
        bookingBuilder.buildFooter();
    }
}

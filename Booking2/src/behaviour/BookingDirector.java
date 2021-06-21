package behaviour;

import structure.Booking;

public class BookingDirector {
    private BookingBuilder bookingBuilder;

    public void setBookingBuilder(BookingBuilder bookingBuilder) {
        this.bookingBuilder = bookingBuilder;
    }
//todo Enum? oder wird es vom Controller angelegt?

    public Booking getBooking(){
        return null;
        //TODO warum brauchen wir die methode??
    }

    public boolean createBooking() {    //Todo Ressource & Payment einfügen und übergeben && boolean to booking
        return bookingBuilder.createNewBooking() != null;
    }
}

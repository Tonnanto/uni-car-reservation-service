package behaviour;

import structure.Booking;

public class BookingDirector {
    private BookingBuilder bookingBuilder;

    public BookingDirector(BookingBuilder bookingBuilder) {
        this.bookingBuilder = bookingBuilder;
    }

    public Booking getBooking(){
        return bookingBuilder.getBooking();
    }

    public void createBooking() {    //Todo Ressource & Payment einfügen und übergeben
        bookingBuilder.buildHeader();
        bookingBuilder.buildBody();
        bookingBuilder.buildFooter();
    }
}

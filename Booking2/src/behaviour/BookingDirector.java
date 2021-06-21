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

    public Booking createBooking(Resource resource, PaymentType paymentType) {
        return  null;
    }
}

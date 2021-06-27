package behaviour;

import model.Payment;
import model.Resource;
import structure.Booking;

public abstract class BookingBuilder {
    protected Booking booking;

    public void createNewBooking(Resource resource, Payment payment) {
        booking = new Booking(resource, payment);
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

    public Booking getBooking() {
        return booking;
    }
}

package behaviour;

import model.PaymentType;
import model.Resource;
import structure.Booking;

public abstract class BookingBuilder {
    protected Booking booking;

    public void createNewBooking(Resource resource, PaymentType paymentType) {
        booking = new Booking(resource, paymentType);
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

    public Booking getBooking() {
        return booking;
    }
}

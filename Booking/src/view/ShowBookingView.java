package view;

import controller.BookingService;
import model.Booking;

public class ShowBookingView extends View {

    private final BookingService bookingService;
    private final Booking booking;

    public ShowBookingView(BookingService bookingService, Booking booking) {
        this.bookingService = bookingService;
        this.booking = booking;
    }

    @Override
    protected String getMessage() {
        return booking.getHeader() + "\n"
                + booking.getBody() + "\n"
                + booking.getFooter();
    }
}

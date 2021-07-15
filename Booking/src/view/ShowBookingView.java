package view;

import controller.BookingService;
import controller.Command;
import controller.commands.ContinueCommand;
import controller.commands.ResetBookingCommand;
import model.Booking;

public class ShowBookingView extends StringInputView {

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
                + booking.getFooter() + "\n" +
                "\n" +
                "Please press ENTER to continue:";
    }

    @Override
    protected Command getCommand(String inputString) {
        return new ContinueCommand(bookingService);
    }

    @Override
    protected boolean isValidString(String s) {
        return true;
    }

    @Override
    protected Command getCancelCommand() {
        return new ResetBookingCommand(bookingService);
    }
}

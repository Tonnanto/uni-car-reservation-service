package view;

import controller.BookingService;
import controller.Command;
import controller.Config;
import controller.commands.ContinueBookingCommand;
import controller.commands.ResetBookingCommand;
import model.Booking;

public class ConfirmBookingView extends StringInputView {

    private final BookingService bookingService;
    private final Booking booking;

    public ConfirmBookingView(BookingService bookingService, Booking booking) {
        this.bookingService = bookingService;
        this.booking = booking;
    }

    @Override
    protected String getMessage() {
        return booking +
                "\n" +
                Config.resourceBundle.getString("booking.view.ConfirmBookingView.getMessage");
    }

    @Override
    protected Command getCommand(String inputString) {
        return new ContinueBookingCommand(bookingService);
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

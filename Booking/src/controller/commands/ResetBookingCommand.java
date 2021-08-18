package controller.commands;

import controller.BookingService;
import view.Language;

public class ResetBookingCommand extends BookingServiceCommand {

    public ResetBookingCommand(BookingService bookingService) {
        super(bookingService);
    }

    @Override
    public void execute() {
        receiver.resetBooking();
    }

    @Override
    public String getDescription() {
        return Language.resourceBundle.getString("booking.controller.commands.ResetBookingCommand.getDescription");
    }
}

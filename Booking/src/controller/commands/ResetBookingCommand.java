package controller.commands;

import controller.BookingService;
import controller.Config;

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
        return Config.resourceBundle.getString("booking.controller.commands.ResetBookingCommand.Description");
    }
}

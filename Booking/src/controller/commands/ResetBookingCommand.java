package controller.commands;

import controller.BookingService;

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
        return "Press X to change the language";
    }
}

package controller.commands;

import controller.BookingService;

public class ContinueBookingCommand extends BookingServiceCommand {

    public ContinueBookingCommand(BookingService bookingService) {
        super(bookingService);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return null;
    }
}

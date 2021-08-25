package controller.commands;

import controller.BookingService;

public class ContinueBookingCommand extends BookingServiceCommand {

    public ContinueBookingCommand(BookingService bookingService) {
        super(bookingService);
    }

    @Override
    public void execute() {
        // By doing nothing the programm will automatically continue
    }
}

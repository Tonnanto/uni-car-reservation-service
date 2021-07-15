package controller.commands;

import controller.BookingService;
import controller.Command;

public class ContinueCommand extends BookingServiceCommand {

    public ContinueCommand(BookingService bookingService){
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

package controller.commands;

import controller.BookingService;
import controller.Command;

public abstract class BookingServiceCommand implements Command {
    protected final BookingService receiver;

    public BookingServiceCommand(BookingService bookingService) {
        this.receiver = bookingService;
    }

    @Override
    public String getDescription() {
        return "";
    }
}

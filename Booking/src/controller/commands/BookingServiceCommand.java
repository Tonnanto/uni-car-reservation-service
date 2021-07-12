package controller.commands;

import controller.BookingService;
import controller.Command;

public abstract class BookingServiceCommand implements Command {
    protected BookingService receiver;

    public BookingServiceCommand(BookingService bookingService) {
        this.receiver = bookingService;
    }
}

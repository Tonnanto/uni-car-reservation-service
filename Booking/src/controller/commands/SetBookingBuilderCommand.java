package controller.commands;

import controller.BookingService;
import view.Language;

public class SetBookingBuilderCommand extends BookingServiceCommand {

    private final Language language;

    public SetBookingBuilderCommand(BookingService bookingService, Language language) {
        super(bookingService);
        this.language = language;
    }

    @Override
    public void execute() {
        receiver.setBookingBuilder(language);
    }

    @Override
    public String getDescription() {
        return language.name();
    }
}

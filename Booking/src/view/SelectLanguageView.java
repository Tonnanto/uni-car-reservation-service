package view;

import controller.BookingService;
import controller.Command;
import controller.Config;
import controller.commands.SetBookingBuilderCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectLanguageView extends SelectionView {

    private final BookingService bookingService;

    public SelectLanguageView(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    protected List<Command> getCommands() {

        List<Command> commands = new ArrayList<>();
        commands.add(new SetBookingBuilderCommand(bookingService, Language.ENGLISH));
        commands.add(new SetBookingBuilderCommand(bookingService, Language.GERMAN));

        return commands;
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("booking.view.SelectLanguageView.getMessage");
    }
}

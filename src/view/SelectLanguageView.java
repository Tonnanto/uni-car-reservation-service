package view;

import controller.CarReservationService;
import controller.Command;
import controller.commands.SetLanguageCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectLanguageView extends SelectionView {

    CarReservationService carReservationService;

    public SelectLanguageView(CarReservationService carReservationService) {
        this.carReservationService = carReservationService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SetLanguageCommand(carReservationService, Language.GERMAN));
        commands.add(new SetLanguageCommand(carReservationService, Language.ENGLISH));
        return commands;
    }

    @Override
    protected String getMessage() {
        return "Please select a Language";
    }
}

package view;

import controller.CarReservationService;
import controller.Command;
import controller.Config;
import controller.commands.SetLanguageCommand;
import model.Language;

import java.util.ArrayList;
import java.util.List;

public class SelectLanguageView extends SelectionView {

    private final CarReservationService carReservationService;

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
        return Config.resourceBundle.getString("utilities.view.SelectLanguageView.Message");
    }
}

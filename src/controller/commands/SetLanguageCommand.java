package controller.commands;

import controller.CarReservationService;
import model.Language;

public class SetLanguageCommand extends CarReservationCommand {

    final private Language language;

    public SetLanguageCommand(CarReservationService carReservationService, Language language) {
        super(carReservationService);
        this.language = language;
    }

    @Override
    public void execute() {
        receiver.setLanguage(language);
    }

    @Override
    public String getDescription() {
        return language.toString();
    }
}

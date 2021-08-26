package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class PromptConfigCommand extends CarReservationCommand {
    public PromptConfigCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.promptConfig();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.PromptConfigCommand.Description");
    }
}

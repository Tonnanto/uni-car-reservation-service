package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class ShowContentCommand extends CarReservationCommand {

    public ShowContentCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.showContent();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.ShowContentCommand.Description");
    }
}

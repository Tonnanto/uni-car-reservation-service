package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class CloseProgrammCommand extends CarReservationCommand {

    public CloseProgrammCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.closeProgramm();
    }

    @Override
    public String getDescription() {
    return Config.resourceBundle.getString("src.controller.commands.CloseContentCommand.Description");
    }
}

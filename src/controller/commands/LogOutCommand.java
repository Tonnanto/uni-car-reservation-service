package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class LogOutCommand extends CarReservationCommand {

    public LogOutCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.logOut();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.LogOutCommand.Description");
    }
}

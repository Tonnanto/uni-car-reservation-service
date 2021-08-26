package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class ReserveResourceCommand extends CarReservationCommand {

    public ReserveResourceCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.reserveResource();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.ReserveResourceCommand.Description");
    }
}

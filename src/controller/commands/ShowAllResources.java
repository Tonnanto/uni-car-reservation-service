package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class ShowAllResources extends CarReservationCommand {

    public ShowAllResources(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.showAllResources();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.ShowAllResources.Description")
                ;
    }
}

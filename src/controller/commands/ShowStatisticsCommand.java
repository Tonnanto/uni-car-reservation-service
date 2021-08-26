package controller.commands;

import controller.CarReservationService;
import controller.Config;

public class ShowStatisticsCommand extends CarReservationCommand {

    public ShowStatisticsCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.showStatistics();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("src.controller.commands.ShowStatisticsCommand.Description");
    }
}

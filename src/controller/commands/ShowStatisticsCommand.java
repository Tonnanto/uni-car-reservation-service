package controller.commands;

import controller.CarReservationService;

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
        return "Show statistics";
    }
}

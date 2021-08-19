package controller.commands;

import controller.CarReservationService;

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
        return "Show Content";
    }
}

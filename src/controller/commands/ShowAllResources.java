package controller.commands;

import controller.CarReservationService;

public class ShowAllResources extends CarReservationCommand{

    public ShowAllResources(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.showAllResources();
    }

    @Override
    public String getDescription() {
        return "Show the cars";
    }
}

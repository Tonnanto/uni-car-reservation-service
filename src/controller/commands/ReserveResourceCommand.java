package controller.commands;

import controller.CarReservationService;

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
        return "Reserve a car";
    }
}

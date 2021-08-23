package controller.commands;

import controller.CarReservationService;
import controller.Command;

public abstract class CarReservationCommand implements Command {

    protected final CarReservationService receiver;

    public CarReservationCommand(CarReservationService carReservationService) {
        this.receiver = carReservationService;
    }
}

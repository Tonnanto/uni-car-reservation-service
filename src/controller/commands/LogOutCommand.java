package controller.commands;

import controller.CarReservationService;

public class LogOutCommand extends CarReservationCommand{

    public LogOutCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.logOut();
    }

    @Override
    public String getDescription() {
        return "Log out";
    }
}

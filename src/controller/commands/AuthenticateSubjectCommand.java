package controller.commands;

import controller.CarReservationService;

public class AuthenticateSubjectCommand extends CarReservationCommand {

    public AuthenticateSubjectCommand(CarReservationService carReservationService) {
        super(carReservationService);
    }

    @Override
    public void execute() {
        receiver.authenticateSubject();
    }

    @Override
    public String getDescription() {
        return "Log in";
    }
}

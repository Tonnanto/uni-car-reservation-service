package controller.commands;

import controller.CarReservationService;
import controller.Config;

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
        return Config.resourceBundle.getString("src.controller.commands.AuthenticateSubjectCommand.Description")
                ;
    }
}

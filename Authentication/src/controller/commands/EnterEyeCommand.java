package controller.commands;

import controller.AuthenticationService;
import controller.Command;

public class EnterEyeCommand extends AuthenticationServiceCommand {


    public EnterEyeCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.authenticateSubject();
    }

    @Override
    public String getDescription() {
        return null;
    }
}

package controller.commands;

import controller.AuthenticationService;
import controller.Command;

public class continueCommand extends AuthenticationServiceCommand {

    public continueCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return "Continue";
    }
}

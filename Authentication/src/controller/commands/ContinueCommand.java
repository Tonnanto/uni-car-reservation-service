package controller.commands;

import controller.AuthenticationService;

public class ContinueCommand extends AuthenticationServiceCommand {

    public ContinueCommand(AuthenticationService authenticationService) {
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

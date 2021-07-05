package controller.commands;

import controller.AuthenticationService;

public class ResetUserNameCommand extends AuthenticationServiceCommand {

    public ResetUserNameCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.resetUsername();
    }

    @Override
    public String getDescription() {
        return "to go back";
    }
}


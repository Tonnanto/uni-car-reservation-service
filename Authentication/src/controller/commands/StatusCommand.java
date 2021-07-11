package controller.commands;

import controller.AuthenticationService;

public class StatusCommand extends AuthenticationServiceCommand {

    public StatusCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.showAuthenticationStatus();
    }

    @Override
    public String getDescription() {
        return "Login Status";
    }
}

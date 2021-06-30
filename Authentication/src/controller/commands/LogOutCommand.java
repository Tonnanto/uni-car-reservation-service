package controller.commands;

import controller.AuthenticationService;

public class LogOutCommand extends AuthenticationServiceCommand {

    public LogOutCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.logout();
    }

    @Override
    public String getDescription() {
        return "Logout";
    }
}

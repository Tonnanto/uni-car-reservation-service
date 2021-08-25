package controller.commands;

import controller.AuthenticationService;
import controller.Command;

public abstract class AuthenticationServiceCommand implements Command {

    protected final AuthenticationService receiver;

    public AuthenticationServiceCommand(AuthenticationService authenticationService) {
        this.receiver = authenticationService;
    }

    @Override
    public String getDescription() {
        return "";
    }
}

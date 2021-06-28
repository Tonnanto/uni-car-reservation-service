package controller.commands;

import controller.AuthenticationService;
import controller.Command;

public abstract class AuthenticationServiceCommand implements Command {

    protected AuthenticationService receiver;

    public AuthenticationServiceCommand(AuthenticationService authenticationService){
        this.receiver = authenticationService;
    }
}

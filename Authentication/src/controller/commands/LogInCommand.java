package controller.commands;

import controller.AuthenticationService;

public class LogInCommand extends AuthenticationServiceCommand {

    public LogInCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.authenticateSubject();
    }

    @Override
    public String getDescription() {
        return "Login";
    }
}

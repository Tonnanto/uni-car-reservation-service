package controller.commands;

import controller.AuthenticationService;
import controller.Config;

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
        return Config.resourceBundle.getString("authentication.controller.commands.LogInCommand.Description");
    }
}

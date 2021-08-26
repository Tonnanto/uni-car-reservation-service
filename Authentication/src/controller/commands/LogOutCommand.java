package controller.commands;

import controller.AuthenticationService;
import controller.Config;

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
        return Config.resourceBundle.getString("authentication.controller.commands.LogOutCommand.Description");
    }
}

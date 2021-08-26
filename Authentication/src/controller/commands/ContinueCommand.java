package controller.commands;

import controller.AuthenticationService;
import controller.Config;

public class ContinueCommand extends AuthenticationServiceCommand {

    public ContinueCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("authentication.controller.commands.ContinueCommand.Description");
    }
}

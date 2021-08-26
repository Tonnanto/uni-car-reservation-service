package controller.commands;

import controller.AuthenticationService;
import controller.Config;

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
        return Config.resourceBundle.getString("authentication.controller.commands.StatusCommand.Description");
    }
}

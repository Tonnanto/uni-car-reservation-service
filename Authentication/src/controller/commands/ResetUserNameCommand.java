package controller.commands;

import controller.AuthenticationService;
import controller.Config;

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
        return Config.resourceBundle.getString("authentication.controller.commands.ResetUserNameCommand.Description");
    }
}


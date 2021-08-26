package controller.commands;

import controller.AuthenticationService;
import controller.Config;

public class ResetCredentialCommand extends AuthenticationServiceCommand {

    public ResetCredentialCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.resetCredential();
    }

    @Override
    public String getDescription() {
        return Config.resourceBundle.getString("authentication.controller.commands.ResetCredentialCommand.Description");
    }
}

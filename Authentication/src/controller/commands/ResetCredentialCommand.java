package controller.commands;

import controller.AuthenticationService;
import view.Language;

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
        return Language.resourceBundle.getString("authentication.controller.commands.ResetCredentialCommand.Description");
    }
}

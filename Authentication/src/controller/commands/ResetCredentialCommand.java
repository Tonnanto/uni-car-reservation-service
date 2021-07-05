package controller.commands;

import controller.AuthenticationService;

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
        return "to go back";
    }
}

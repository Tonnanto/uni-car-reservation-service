package controller.commands;

import controller.AuthenticationService;
import view.Language;

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
        return Language.resourceBundle.getString("authentication.controller.commands.StatusCommand.Description");
    }
}

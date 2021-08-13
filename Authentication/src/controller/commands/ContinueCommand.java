package controller.commands;

import controller.AuthenticationService;
import view.Language;

public class ContinueCommand extends AuthenticationServiceCommand {

    public ContinueCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return Language.resourceBundle.getString("authentication.controller.commands.ContinueCommand.Description");
    }
}

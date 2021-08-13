package controller.commands;

import controller.AuthenticationService;
import view.Language;

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
        return Language.resourceBundle.getString("authentication.controller.commands.LogOutCommand.Description");
    }
}

package controller.commands;

import controller.AuthenticationService;
import view.AuthenticationServiceView;
import view.ShowLoginStatusView;

public class StatusCommand extends AuthenticationServiceCommand {

    public StatusCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        new ShowLoginStatusView(receiver).display();
        new AuthenticationServiceView(receiver).display();
    }

    @Override
    public String getDescription() {
        return "Login Status";
    }
}

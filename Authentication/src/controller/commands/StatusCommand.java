package controller.commands;

import controller.AuthenticationService;
import view.SelectAuthenticationServiceView;
import view.ShowLoginStatusView;

public class StatusCommand extends AuthenticationServiceCommand {

    public StatusCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        new ShowLoginStatusView(receiver).display();
        new SelectAuthenticationServiceView(receiver).display();
    }

    @Override
    public String getDescription() {
        return "Login Status";
    }
}

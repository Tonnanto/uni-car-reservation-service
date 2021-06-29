package controller.commands;

import controller.AuthenticationService;
import model.UserNamePasswordStrategy;

public class EnterUserNameCommand extends AuthenticationServiceCommand {

    private final String username;

    public EnterUserNameCommand(AuthenticationService authenticationService, String username) {
        super(authenticationService);
        this.username = username;
    }

    @Override
    public void execute() {
        receiver.setUsername(username);
    }

    @Override
    public String getDescription() {
        return null;
    }
}

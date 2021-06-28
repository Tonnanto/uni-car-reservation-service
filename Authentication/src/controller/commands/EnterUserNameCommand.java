package controller.commands;

import controller.AuthenticationService;
import model.UserNamePasswordStrategy;

public class EnterUserNameCommand extends AuthenticationServiceCommand {

    private final String username;
    private final UserNamePasswordStrategy credential;

    public EnterUserNameCommand(AuthenticationService authenticationService, String username, UserNamePasswordStrategy credential) {
        super(authenticationService);
        this.username = username;
        this.credential = credential;
    }

    @Override
    public void execute() {
        credential.setUsername(username);
    }

    @Override
    public String getDescription() {
        return credential.getUsername();
    }
}

package controller.commands;

import controller.AuthenticationService;
import model.UserNamePasswordStrategy;

public class EnterPasswordCommand extends AuthenticationServiceCommand{

    private final String password;
    private final UserNamePasswordStrategy credential;

    public EnterPasswordCommand(AuthenticationService authenticationService, String password, UserNamePasswordStrategy credential) {
        super(authenticationService);
        this.password = password;
        this.credential = credential;
    }

    @Override
    public void execute() {
        credential.setPassword(password);
    }

    @Override
    public String getDescription() {
        return credential.getPassword();
    }
}

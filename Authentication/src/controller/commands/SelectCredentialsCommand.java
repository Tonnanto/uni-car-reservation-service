package controller.commands;

import controller.AuthenticationService;
import model.Credential;

public class SelectCredentialsCommand extends AuthenticationServiceCommand{
    private final String credential;

    public SelectCredentialsCommand(AuthenticationService authenticationService, String credential) {
        super(authenticationService);
        this.credential = credential;
    }

    @Override
    public void execute() {
        receiver.setCredential(credential);
    }

    @Override
    public String getDescription() {
        return credential;
    }
}

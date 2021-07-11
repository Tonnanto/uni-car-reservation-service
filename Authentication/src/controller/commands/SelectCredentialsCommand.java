package controller.commands;

import controller.AuthenticationService;
import model.Credential;

public class SelectCredentialsCommand extends AuthenticationServiceCommand {
    private final Credential credential;

    public SelectCredentialsCommand(AuthenticationService authenticationService, Credential credential) {
        super(authenticationService);
        this.credential = credential;
    }

    @Override
    public void execute() {
        receiver.setCredential(credential);
    }

    @Override
    public String getDescription() {
        return credential.getDescription();
    }
}

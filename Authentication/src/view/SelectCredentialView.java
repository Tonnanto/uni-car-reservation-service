package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.SelectCredentialsCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectCredentialView extends SelectionView {

    private final AuthenticationService authenticationService;

    public SelectCredentialView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected List<Command> getCommands() {

        List <Command> commands = new ArrayList<>();
        commands.add(new SelectCredentialsCommand(authenticationService, "Username and Password"));
        commands.add(new SelectCredentialsCommand(authenticationService, "Fingerprint"));
        commands.add(new SelectCredentialsCommand(authenticationService, "Eyescan"));
        return commands;
    }

    @Override
    protected String getMessage() {
        return "Please select your login method:";
    }
}

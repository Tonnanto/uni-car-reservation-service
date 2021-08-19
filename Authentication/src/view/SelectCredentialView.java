package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.SelectCredentialsCommand;
import model.EyeScanStrategy;
import model.FingerPrintStrategy;
import model.UserNamePasswordStrategy;

import java.util.ArrayList;
import java.util.List;

public class SelectCredentialView extends SelectionView {

    private final AuthenticationService authenticationService;

    public SelectCredentialView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected List<Command> getCommands() {

        List<Command> commands = new ArrayList<>();                                //TODO new Credential
        commands.add(new SelectCredentialsCommand(authenticationService, new UserNamePasswordStrategy()));
        commands.add(new SelectCredentialsCommand(authenticationService, new FingerPrintStrategy()));
        commands.add(new SelectCredentialsCommand(authenticationService, new EyeScanStrategy()));
        return commands;
    }

    @Override
    protected String getMessage() {
        return Language.resourceBundle.getString("authentication.view.SelectCredentialView.Message");
    }
}

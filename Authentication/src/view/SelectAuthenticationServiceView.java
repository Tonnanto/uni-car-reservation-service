package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.LogInCommand;
import controller.commands.LogOutCommand;
import controller.commands.StatusCommand;
import controller.commands.continueCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectAuthenticationServiceView extends SelectionView {

    private final AuthenticationService authenticationService;

    public SelectAuthenticationServiceView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new LogInCommand(authenticationService));
        commands.add(new LogOutCommand(authenticationService));
        commands.add(new StatusCommand(authenticationService));
        if (authenticationService.isSubjectAuthenticated())
            commands.add(new continueCommand(authenticationService));
        return commands;
    }

    @Override
    protected String getMessage() {
        return "Please select a action: ";
    }
}

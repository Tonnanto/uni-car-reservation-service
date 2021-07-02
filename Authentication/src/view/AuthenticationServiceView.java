package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.LogInCommand;
import controller.commands.LogOutCommand;
import controller.commands.StatusCommand;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationServiceView extends SelectionView {

    private final AuthenticationService authenticationService;

    public AuthenticationServiceView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new LogInCommand(authenticationService));
        commands.add(new LogOutCommand(authenticationService));
        commands.add(new StatusCommand(authenticationService));
        return commands;
    }

    @Override
    protected String getMessage() {
        return "Please select a action: ";
    }
}

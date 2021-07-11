package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.ContinueCommand;
import controller.commands.LogInCommand;
import controller.commands.LogOutCommand;
import controller.commands.StatusCommand;

import java.util.ArrayList;
import java.util.List;

public class SelectUseCaseView extends SelectionView {

    private final AuthenticationService authenticationService;

    public SelectUseCaseView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        if (!authenticationService.isSubjectAuthenticated())
            commands.add(new LogInCommand(authenticationService));
        else commands.add(new LogOutCommand(authenticationService));

        commands.add(new StatusCommand(authenticationService));

        if (authenticationService.isSubjectAuthenticated())
            commands.add(new ContinueCommand(authenticationService));

        return commands;
    }

    @Override
    protected String getMessage() {
        return "Please select a action: ";
    }
}

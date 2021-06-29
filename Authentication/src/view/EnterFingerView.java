package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterFingerCommand;

public class EnterFingerView extends StringInputView {

    private final AuthenticationService authenticationService;

    public EnterFingerView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new EnterFingerCommand(authenticationService);
    }

    @Override
    protected String getMessage() {
        return "Bitte halten Sie ihren Finger auf die ENTER Taste!";
    }
}

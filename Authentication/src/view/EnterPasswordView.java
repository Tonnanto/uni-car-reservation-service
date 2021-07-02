package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterPasswordCommand;

public class EnterPasswordView extends StringInputView {

    private final AuthenticationService authenticationService;

    public EnterPasswordView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new EnterPasswordCommand(authenticationService, inputString);
    }

    @Override
    protected String getMessage() {
        return "Please enter your password: ";
    }
}

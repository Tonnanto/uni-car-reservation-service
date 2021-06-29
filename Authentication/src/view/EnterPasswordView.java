package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterPasswordCommand;
import model.UserNamePasswordStrategy;

public class EnterPasswordView extends StringInputView{

    private final AuthenticationService authenticationService;
    private final UserNamePasswordStrategy credential;

    public EnterPasswordView(AuthenticationService authenticationService, UserNamePasswordStrategy credential) {
        this.authenticationService = authenticationService;
        this.credential = credential;
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

package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterUserNameCommand;

public class EnterUserNameView extends StringInputView {

    private final AuthenticationService authenticationService;

    public EnterUserNameView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new EnterUserNameCommand(authenticationService, inputString);
    }

    @Override
    protected String getMessage() {
        return "Please enter your username: ";
    }
}

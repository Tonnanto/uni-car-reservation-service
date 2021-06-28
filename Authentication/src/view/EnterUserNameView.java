package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterUserNameCommand;
import model.UserNamePasswordStrategy;

public class EnterUserNameView extends StringInputView{

    private final AuthenticationService authenticationService;
    private final UserNamePasswordStrategy credential;

    public EnterUserNameView(AuthenticationService authenticationService, UserNamePasswordStrategy credential) {
        this.authenticationService = authenticationService;
        this.credential = credential;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new EnterUserNameCommand(authenticationService, inputString, credential);
    }

    @Override
    protected String getMessage() {
        return "Please enter your username: ";
    }
}

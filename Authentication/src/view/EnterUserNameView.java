package view;

import controller.AuthenticationService;
import controller.Command;
import controller.commands.EnterUserNameCommand;
import controller.commands.ResetCredentialCommand;

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
        return Language.resourceBundle.getString("authentication.view.EnterUserNameView.Message");
    }

    @Override
    protected Command getCancelCommand() {
        return new ResetCredentialCommand(authenticationService);
    }
}

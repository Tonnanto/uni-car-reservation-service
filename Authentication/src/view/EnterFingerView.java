package view;

import controller.AuthenticationService;
import controller.Command;
import controller.Config;
import controller.commands.EnterFingerCommand;
import controller.commands.ResetCredentialCommand;

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
        return Config.resourceBundle.getString("authentication.view.EnterFingerView.Message");
    }

    @Override
    protected boolean isValidString(String s) {
        return s.isEmpty();
    }

    @Override
    protected String getValidationMessage() {
        return Config.resourceBundle.getString("authentication.view.EnterFingerView.ValidationMessage");
    }

    @Override
    protected Command getCancelCommand() {
        return new ResetCredentialCommand(authenticationService);
    }
}

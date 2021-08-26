package view;

import controller.AuthenticationService;
import controller.Command;
import controller.Config;
import controller.commands.EnterEyeCommand;
import controller.commands.ResetCredentialCommand;

public class EnterEyeView extends StringInputView {

    private final AuthenticationService authenticationService;

    public EnterEyeView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return new EnterEyeCommand(authenticationService);
    }

    @Override
    protected String getMessage() {
        return Config.resourceBundle.getString("authentication.view.EnterEyeView.Message");
    }

    @Override
    protected boolean isValidString(String s) {
        return s.isEmpty();
    }

    @Override
    protected String getValidationMessage() {
        return Config.resourceBundle.getString("authentication.view.EnterEyeView.ValidationMessage");
    }

    @Override
    protected Command getCancelCommand() {
        return new ResetCredentialCommand(authenticationService);
    }
}

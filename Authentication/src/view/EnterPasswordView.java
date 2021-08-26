package view;

import controller.AuthenticationService;
import controller.Command;
import controller.Config;
import controller.commands.EnterPasswordCommand;
import controller.commands.ResetUserNameCommand;

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
        return Config.resourceBundle.getString("authentication.view.EnterPasswordView.Message");
    }

    @Override
    protected Command getCancelCommand() {
        return new ResetUserNameCommand(authenticationService);
    }
}

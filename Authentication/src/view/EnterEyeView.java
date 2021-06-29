package view;

import controller.AuthenticationService;
import controller.Command;

public class EnterEyeView extends StringInputView{

    private final AuthenticationService authenticationService;

    public EnterEyeView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected Command getCommand(String inputString) {
        return null;
    }

    @Override
    protected String getMessage() {
        return "Look in the camera and hit ENTER!";
    }
}

package controller.commands;

import controller.AuthenticationService;

public class EnterFingerCommand extends AuthenticationServiceCommand {

    public EnterFingerCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.updateSubjectAuthenticated();
    }
}

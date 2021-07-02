package controller.commands;

import controller.AuthenticationService;

public class EnterEyeCommand extends AuthenticationServiceCommand {


    public EnterEyeCommand(AuthenticationService authenticationService) {
        super(authenticationService);
    }

    @Override
    public void execute() {
        receiver.setSubjectAuthenticated();
    }

    @Override
    public String getDescription() {
        return null;
    }
}

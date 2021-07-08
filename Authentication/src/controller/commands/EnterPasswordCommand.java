package controller.commands;

import controller.AuthenticationService;

public class EnterPasswordCommand extends AuthenticationServiceCommand {

    private final String password;

    public EnterPasswordCommand(AuthenticationService authenticationService, String password) {
        super(authenticationService);
        this.password = password;
    }

    @Override
    public void execute() {
        receiver.setPassword(password);
        receiver.updateSubjectAuthenticated();
    }

    @Override
    public String getDescription() {
        return password;
    }
}

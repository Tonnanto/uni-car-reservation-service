package controller.commands;

import controller.PaymentService;

public class SetUsernameCommand extends PaymentServiceCommand {
    private final String username;

    public SetUsernameCommand(PaymentService receiver, String username) {
        super(receiver);
        this.username = username;
    }

    @Override
    public void execute() {
        receiver.setUsername(username);
    }

    @Override
    public String getDescription() {
        return null;
    }
}

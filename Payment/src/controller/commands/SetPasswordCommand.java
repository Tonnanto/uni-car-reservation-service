package controller.commands;

import controller.PaymentService;

public class SetPasswordCommand extends PaymentServiceCommand {
    private final String password;

    public SetPasswordCommand(PaymentService receiver, String password) {
        super(receiver);
        this.password = password;
    }

    @Override
    public void execute() {
        receiver.setPassword(password);
    }

    @Override
    public String getDescription() {
        return null;
    }
}

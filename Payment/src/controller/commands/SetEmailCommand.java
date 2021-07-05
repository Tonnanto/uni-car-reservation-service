package controller.commands;

import controller.PaymentService;

public class SetEmailCommand extends PaymentServiceCommand {
    private final String email;

    public SetEmailCommand(PaymentService receiver, String email) {
        super(receiver);
        this.email = email;
    }

    @Override
    public void execute() {
        receiver.setEmail(email);
    }

    @Override
    public String getDescription() {
        return null;
    }
}
